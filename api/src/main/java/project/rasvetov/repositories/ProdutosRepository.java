package project.rasvetov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.rasvetov.model.Produto;

public interface ProdutosRepository  extends JpaRepository<Produto, Integer> {
}
