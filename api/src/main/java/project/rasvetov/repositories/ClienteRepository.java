package project.rasvetov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.rasvetov.model.Cliente;

import java.util.List;

// Classe responsável por acessar o banco de dados diretamente para fazer operações para a classe cliente
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

    boolean existsByNome(String nome);
    @Modifying
    void deleteByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos p where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);


}
