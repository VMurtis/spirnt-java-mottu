package br.com.fiap.sprint.mottu.repository;


import br.com.fiap.sprint.mottu.entity.MotoLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoLogRepository extends JpaRepository<MotoLog, Long> {
}
