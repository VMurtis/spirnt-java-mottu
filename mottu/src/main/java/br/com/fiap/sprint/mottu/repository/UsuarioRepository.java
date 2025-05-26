package br.com.fiap.sprint.mottu.repository;


import br.com.fiap.sprint.mottu.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
