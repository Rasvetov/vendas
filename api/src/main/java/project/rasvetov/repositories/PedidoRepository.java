package project.rasvetov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.rasvetov.model.Cliente;
import project.rasvetov.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository {

    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left join fetch p.itens where p.id = :id")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}
