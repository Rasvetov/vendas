package project.rasvetov.dto;


import lombok.Getter;
import lombok.Setter;
//classe que transfere dados simples dentro da aplicação referente aos status dos pedidos
@Getter
@Setter
public class AtualizacaoStatusPedidoDto {
    private String novoStatus;
}
