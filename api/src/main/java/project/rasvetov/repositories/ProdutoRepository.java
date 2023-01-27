package project.rasvetov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.rasvetov.model.Produto;
// Classe responsável por acessar o banco de dados diretamente para fazer operações para a classe produto
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
