package project.rasvetov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//classe que transfere dados simples dentro da aplicação referente aos itens pedidos
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDto {
    private Integer produto;
    private Integer quantidade;
}
