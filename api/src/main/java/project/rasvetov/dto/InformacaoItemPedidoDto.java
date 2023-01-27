package project.rasvetov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//classe que transfere dados simples dentro da aplicação referente as informações dos itens pedidos
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacaoItemPedidoDto {
    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
