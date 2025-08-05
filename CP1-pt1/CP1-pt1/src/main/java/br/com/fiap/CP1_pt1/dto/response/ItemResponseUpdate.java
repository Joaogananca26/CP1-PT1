package br.com.fiap.CP1_pt1.dto.response;

import lombok.Data;

@Data
public class ItemResponseUpdate {
    private String nomeitem;
    private String tipoitem;
    private String classificacaoitem;
    private double tamanhoitem;
    private double precoItem;
}
