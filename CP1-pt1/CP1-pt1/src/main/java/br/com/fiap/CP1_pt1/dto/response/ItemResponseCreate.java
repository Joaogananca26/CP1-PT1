package br.com.fiap.CP1_pt1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseCreate {
    private UUID idItem;
    private String nomeItem;
    private String tipoItem;
    private String classificacaoItem;
    private double tamanhoItem;
    private double precoItem;

}
