package br.com.fiap.CP1_pt1.dto.request;

import lombok.Data;

@Data
public class ItemRequestUpdate {
    private String nomeitem;
    private String tipoitem;
    private String classificacaoitem;
    private double tamanhoitem;
    private double precoItem;
}
