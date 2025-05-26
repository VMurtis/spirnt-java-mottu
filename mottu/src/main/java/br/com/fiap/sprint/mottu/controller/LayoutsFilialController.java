package br.com.fiap.sprint.mottu.controller;




import br.com.fiap.sprint.mottu.entity.LayoutsFilial;
import br.com.fiap.sprint.mottu.repository.LayoutRepository;
import br.com.fiap.sprint.mottu.dto.layoutsFilial.LayoutsFilialDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/layoutsFilial")
public class LayoutsFilialController {

    @Autowired
    LayoutRepository layoutRepository;


    @GetMapping
    public List<LayoutsFilial> ListartodasLayouts(){
        return layoutRepository.findAll();
    }


    @PostMapping
    public void criarLayoutFilial(@RequestBody @Valid LayoutsFilialDTO layoutsFilialDTO) {
        LayoutsFilial layoutsFilial = new LayoutsFilial(layoutsFilialDTO);
        layoutRepository.save(layoutsFilial);
    }

    @PutMapping("/{id}")
    public LayoutsFilial atualizarLayoutsFilial(@PathVariable Long id, @RequestBody @Valid LayoutsFilialDTO layoutsFilialDTO) {
        LayoutsFilial layoutsFilialExistente = layoutRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Layouts filial não encontrada"));

        layoutsFilialExistente.setInfo_layout(layoutsFilialDTO.info_layout());

        return layoutRepository.save(layoutsFilialExistente);
    }


    @DeleteMapping("/{id}")
    public void excluirLayoutFilial(@PathVariable Long id) {
        if (!layoutRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Layout não encontrada");
        }

        layoutRepository.deleteById(id);
    }



    @GetMapping("/{id}")
    public LayoutsFilial consultarLayoutFilialPorId(@PathVariable Long id) {
        return layoutRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Layout não encontrada"));
    }
}
