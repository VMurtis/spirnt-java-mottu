package br.com.fiap.sprint.mottu.service;

import br.com.fiap.sprint.mottu.entity.Filial;
import br.com.fiap.sprint.mottu.repository.FilialRepository;
import br.com.fiap.sprint.mottu.dto.filial.FilialDTO;
import br.com.fiap.sprint.mottu.dto.filial.FilialGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.sprint.mottu.entity.Usuario;
import br.com.fiap.sprint.mottu.entity.Moto;

import java.util.Optional;
import java.util.List;

@Service
public class FilialService {

    @Autowired
    private FilialRepository repository;

    public Filial save(FilialDTO dto) {
        return repository.save(new Filial(dto));
    }

    public List<FilialGetDTO> getAll() {
        return repository.findAll().stream().map(FilialGetDTO::new).toList();
    }



    public FilialGetDTO getId(Long id) {
        Optional<Filial> filial = repository.findById(id);

        if (filial.isPresent()) {
            Filial f = filial.get();
            return new FilialGetDTO(
                    f.getId(),
                    f.getFilialName(),
                    f.getEndereco(),
                    f.getContato(),
                    f.getHorario_funcionamento(),
                    f.getLayoutsFilial() != null ? f.getLayoutsFilial().getId() : null,
                    f.getUsuarios() != null ?
                            f.getUsuarios().stream().map(Usuario::getId).toList() :
                            List.of(),
                    f.getMotos() != null ?
                            f.getMotos().stream().map(Moto::getIdMoto).toList() :
                            List.of()
            );
        } else {
            return null;
        }

    }

    public FilialGetDTO update(Long id, FilialGetDTO dto) {
        Filial filial = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filial não encontrada"));

        filial.setFilialName(dto.filial_name());
        filial.setEndereco(dto.endereco());
        filial.setContato(dto.contato());
        filial.setHorario_funcionamento(dto.horario_funcionamento());

        Filial atualizado = repository.save(filial);
        return new FilialGetDTO(atualizado);
    }

    public void delete(Long id) {
        Filial filial = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filial não encontrada"));

        repository.delete(filial);
    }
}
