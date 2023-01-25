package project.rasvetov.services;

import project.rasvetov.dto.PedidoDto;
import project.rasvetov.enums.StatusPedido;
import project.rasvetov.model.Pedido;

import java.util.Optional;

//classe que recebe toda a regra de negócio da aplicação
public interface PedidoService {
    Pedido salvar(PedidoDto dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
