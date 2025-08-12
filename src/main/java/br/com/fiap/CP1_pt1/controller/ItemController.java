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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/ferramentas")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public ResponseEntity<ItemResponseCreate> cadastrarItem(@Valid @RequestBody ItemRequestCreate itemRequestCreate) {
        Item item = Item.builder()
                .nomeItem(itemRequestCreate.getNomeItem())
                .tipoItem(itemRequestCreate.getTipoItem())
                .classificacaoItem(itemRequestCreate.getClassificacaoItem())
                .tamanhoItem(itemRequestCreate.getTamanhoItem())
                .precoItem(itemRequestCreate.getPrecoItem())
                .build();

        itemService.createItem(item);

        ItemResponseCreate response = new ItemResponseCreate(
                item.getIdItem(),
                item.getNomeItem(),
                item.getTipoItem(),
                item.getClassificacaoItem(),
                item.getTamanhoItem(),
                item.getPrecoItem()
        );

        response.add(linkTo(methodOn(ItemController.class).lerItemEspecifico(item.getIdItem())).withSelfRel());
        response.add(linkTo(methodOn(ItemController.class).lerItems()).withRel("listar-todos"));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseCreate> lerItemEspecifico(@PathVariable UUID id) {
        Item item = itemService.obterItemPorId(id);

        ItemResponseCreate response = new ItemResponseCreate(
                item.getIdItem(),
                item.getNomeItem(),
                item.getTipoItem(),
                item.getClassificacaoItem(),
                item.getTamanhoItem(),
                item.getPrecoItem()
        );

        response.add(linkTo(methodOn(ItemController.class).lerItemEspecifico(id)).withSelfRel());
        response.add(linkTo(methodOn(ItemController.class).lerItems()).withRel("listar-todos"));
        response.add(linkTo(methodOn(ItemController.class).atualizarDadosItem(id, null)).withRel("atualizar"));
        response.add(linkTo(methodOn(ItemController.class).atualizarDadoItem(id, null)).withRel("atualizar-preco"));

        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    public ResponseEntity<List<ItemResponseCreate>> lerItems() {
        List<ItemResponseCreate> itens = itemService.listarItens();

        itens.forEach(item ->
                item.add(linkTo(methodOn(ItemController.class).lerItemEspecifico(item.getIdItem())).withSelfRel())
        );

        return ResponseEntity.ok(itens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseCreate> atualizarDadosItem(@PathVariable UUID id, @Valid @RequestBody ItemRequestCreate item) {
        try {
            itemService.atualizarItem(id, item);
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemResponseUpdate> atualizarDadoItem(@PathVariable UUID id, @RequestBody ItemRequestUpdate itemPreco) {
        try {
            itemService.atualizarPrecoItem(id, itemPreco);
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
