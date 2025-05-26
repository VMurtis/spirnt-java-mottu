package br.com.fiap.sprint.mottu.repository;


import br.com.fiap.sprint.mottu.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
