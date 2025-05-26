package br.com.fiap.sprint.mottu.controller;

import br.com.fiap.sprint.mottu.dto.filial.FilialDTO;
import br.com.fiap.sprint.mottu.entity.Filial;
import br.com.fiap.sprint.mottu.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/filial")
public class FilialController {

    @Autowired
    FilialRepository filialRepository;


    @GetMapping
    public List<Filial> ListartodasFiliais(){
        return filialRepository.findAll();
    }



    @PostMapping
    public void criarFilial(@RequestBody @Valid FilialDTO filialDTO) {
        Filial filial = new Filial(filialDTO);
        filialRepository.save(filial);
    }

    @PutMapping("/{id}")
    public Filial atualizarFilial(@PathVariable Long id, @RequestBody @Valid FilialDTO filialDTO) {
        Filial filialExistente = filialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Filial não encontrada"));

        filialExistente.setFilialName(filialDTO.filial_name());
        filialExistente.setEndereco(filialDTO.endereco());
        filialExistente.setContato(filialDTO.contato());

        return filialRepository.save(filialExistente);
    }


    @DeleteMapping("/{id}")
    public void excluirFilial(@PathVariable Long id) {
        if (!filialRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada");
        }

        filialRepository.deleteById(id);
    }



    @GetMapping("/{id}")
    public Filial consultarFilialPorId(@PathVariable Long id) {
        return filialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada"));
    }

}
