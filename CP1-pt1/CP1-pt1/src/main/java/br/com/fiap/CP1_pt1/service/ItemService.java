package br.com.fiap.CP1_pt1.service;

import br.com.fiap.CP1_pt1.dto.request.ItemRequestCreate;
import br.com.fiap.CP1_pt1.dto.request.ItemRequestUpdate;
import br.com.fiap.CP1_pt1.entity.Item;
import br.com.fiap.CP1_pt1.exception.ItemNaoEncontradoException;
import br.com.fiap.CP1_pt1.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ItemService {
    private ItemRepository repository;

    public Item createItem(Item item) {
        return repository.save(item);
    }

    public List<Item> listarItens() {
        return repository.findAll();
    }

    public Item obterItemPorId(String id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException("Item não encontrado com o ID: " + id));
    }

    public void deletarItemPorId(String id) {
        if (!repository.existsById(id)) {
            throw new ItemNaoEncontradoException("Item não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

    public Item atualizarItem(String id, @Valid ItemRequestUpdate itemAtualizado) {
        Item itemExistente = obterItemPorId(id);

        itemExistente.setNomeitem(itemAtualizado.getNomeitem());
        itemExistente.setTipoitem(itemAtualizado.getTipoitem());
        itemExistente.setClassificacaoitem(itemAtualizado.getClassificacaoitem());
        itemExistente.setTamanhoitem(itemAtualizado.getTamanhoitem());
        itemExistente.setPrecoItem(itemAtualizado.getPrecoItem());

        return repository.save(itemExistente);
    }

}
