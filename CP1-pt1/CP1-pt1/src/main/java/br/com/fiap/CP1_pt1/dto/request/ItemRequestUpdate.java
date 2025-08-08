package br.com.fiap.CP1_pt1.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestUpdate {
    @NotNull(message = "O preço do item não pode ficar em branco")
    @Min(value = 1,message = "o item não pode custar menos de 1 real")
    @Max(value = 999999,message = "o item não pode custar mais de 1 milhão")
    private double precoItem;
}
