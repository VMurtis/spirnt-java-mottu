package br.com.fiap.sprint.mottu.repository;


import br.com.fiap.sprint.mottu.entity.LayoutsFilial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LayoutRepository extends JpaRepository<LayoutsFilial, Long> {
}
