package br.com.fiap.CP1_pt1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String iditem;

    @Column(name = "nome_item", nullable = false, length = 50)
    private String nomeitem;

    @Column(name = "tipo_item", nullable = false, length = 50)
    private String tipoitem;

    @Column(name = "classificacao_item", nullable = false, length = 50)
    private String classificacaoitem;

    @Column(name = "tamanho_item", nullable = false, length = 50)
    private double tamanhoitem;

    @Column(name = "preco_item", nullable = false, length = 50)
    private double precoItem;
}
