package project.rasvetov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//classe que transfere dados simples dentro da aplicação
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDto> itens;
}