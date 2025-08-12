package br.com.fiap.CP1_pt1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseCreate extends RepresentationModel<ItemResponseCreate> {

    private UUID idItem;
    private String nomeItem;
    private String tipoItem;
    private String classificacaoItem;
    private double tamanhoItem;
    private double precoItem;

}
