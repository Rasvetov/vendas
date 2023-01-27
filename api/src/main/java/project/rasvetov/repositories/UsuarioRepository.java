package project.rasvetov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.rasvetov.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
}
