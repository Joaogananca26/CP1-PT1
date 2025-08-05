package br.com.fiap.CP1_pt1.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemRequestCreate {

    @NotBlank(message = "O nome do item não pode ficar em branco")
    private String nomeitem;

    @NotBlank(message = "O tipo do item não pode ficar em branco")
    private String tipoitem;

    @NotBlank(message = "A classificação do item não pode ficar em branco")
    private String classificacaoitem;

    @NotBlank(message = "O tamanho do item não pode ficar em branco")
    private double tamanhoitem;

    @NotBlank(message = "O preço do item não pode ficar em branco")
    private double precoItem;
}
