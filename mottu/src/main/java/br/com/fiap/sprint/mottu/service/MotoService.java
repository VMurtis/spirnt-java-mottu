package br.com.fiap.sprint.mottu.service;

import br.com.fiap.sprint.mottu.dto.moto.MotoGetDTO;
import br.com.fiap.sprint.mottu.entity.Filial;
import br.com.fiap.sprint.mottu.entity.Moto;
import br.com.fiap.sprint.mottu.entity.enums.TipoMoto;
import br.com.fiap.sprint.mottu.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.sprint.mottu.dto.moto.MotoDTO;
import br.com.fiap.sprint.mottu.repository.FilialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {
    @Autowired
    private MotoRepository repository;

    @Autowired
    private FilialRepository filialRepository;

    public Moto save(MotoDTO dto) {
        Filial filial = filialRepository.findById(dto.filialId())
                .orElseThrow(() -> new RuntimeException("Filial não encontrado"));
        return repository.save(new Moto(dto, filial));
    }

    public List<MotoGetDTO> getAll() {
        return repository.findAll().stream().map(MotoGetDTO::new).toList();
    }



}
