package project.rasvetov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.rasvetov.validation.NotEmptyList;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

//classe que transfere dados simples dentro da aplicação referente aos pedidos
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;
    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;
    @NotEmptyList(message = "{campo.itens-pedido.obrigatorio}")
    private List<ItemPedidoDto> itens;
}
