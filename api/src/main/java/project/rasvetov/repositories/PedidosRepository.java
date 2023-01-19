package project.rasvetov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.rasvetov.model.Cliente;
import project.rasvetov.model.Pedido;

import java.util.List;

public interface PedidosRepository extends JpaRepository {

    List<Pedido> findByCliente(Cliente cliente);
}
