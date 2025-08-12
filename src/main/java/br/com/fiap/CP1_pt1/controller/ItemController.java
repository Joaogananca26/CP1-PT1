package br.com.fiap.CP1_pt1.controller;

import br.com.fiap.CP1_pt1.dto.request.ItemRequestCreate;
import br.com.fiap.CP1_pt1.dto.request.ItemRequestUpdate;
import br.com.fiap.CP1_pt1.dto.response.ItemResponseCreate;
import br.com.fiap.CP1_pt1.dto.response.ItemResponseUpdate;
import br.com.fiap.CP1_pt1.entity.Item;
import br.com.fiap.CP1_pt1.exception.ItemNaoEncontradoException;
import br.com.fiap.CP1_pt1.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ferramentas")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public ResponseEntity<ItemResponseCreate> cadastrarItem(@Valid @RequestBody ItemRequestCreate itemRequestCreate){
       Item item = Item.builder()
                .nomeItem(itemRequestCreate.getNomeItem())
                .tipoItem(itemRequestCreate.getTipoItem())
                .classificacaoItem(itemRequestCreate.getClassificacaoItem())
                .tamanhoItem(itemRequestCreate.getTamanhoItem())
                .precoItem(itemRequestCreate.getPrecoItem())
                .build();
       itemService.createItem(item);

            return ResponseEntity.ok(new ItemResponseCreate(item.getIdItem(),item.getNomeItem(),item.getTipoItem(),item.getClassificacaoItem(),
                    item.getTamanhoItem(),item.getPrecoItem()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseCreate> lerItemEspecifico(@PathVariable UUID id){
       Item item = itemService.obterItemPorId(id);
        return ResponseEntity.ok(new ItemResponseCreate(item.getIdItem(), item.getNomeItem(), item.getTipoItem(),
                item.getClassificacaoItem(), item.getTamanhoItem(), item.getPrecoItem()));
    }

    @GetMapping("")
    public ResponseEntity<List<ItemResponseCreate>> lerItems(){
       List<ItemResponseCreate> itens = itemService.listarItens();
        try{
            return ResponseEntity.ok(itens);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseCreate> atualizarDadosItem(@PathVariable UUID id,@Valid @RequestBody ItemRequestCreate item){
        try {
            itemService.atualizarItem(id, item);
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemResponseUpdate> atualizarDadoItem(@PathVariable UUID id, @RequestBody ItemRequestUpdate itemPreco){
        try {
            itemService.atualizarPrecoItem(id, itemPreco);
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
