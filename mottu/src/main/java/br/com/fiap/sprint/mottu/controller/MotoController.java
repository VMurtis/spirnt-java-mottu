package br.com.fiap.sprint.mottu.controller;



import br.com.fiap.sprint.mottu.dto.moto.MotoDTO;
import br.com.fiap.sprint.mottu.entity.Moto;
import br.com.fiap.sprint.mottu.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    MotoRepository motoRepository;


    @GetMapping
    public List<Moto> ListartodasMotos(){
        return motoRepository.findAll();
    }



    @PostMapping
    public void criarMoto(@RequestBody @Valid MotoDTO motoDTO) {
        Moto moto = new Moto(motoDTO);
        motoRepository.save(moto);
    }

    @PutMapping("/{id}")
    public Moto atualizarMoto(@PathVariable Long id, @RequestBody @Valid MotoDTO motoDTO) {
        Moto motoExistente = motoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));

        motoExistente.setPlaca(motoDTO.placa());
        motoExistente.setChassi(motoDTO.chassi());
        motoExistente.setIot_info(motoDTO.iot_info());
        motoExistente.setRfid_tag(motoDTO.rfid_tag());
        motoExistente.setLocalizacao(motoDTO.localizacao());
        motoExistente.setStatus_atual(motoDTO.status_atual());

        return motoRepository.save(motoExistente);
    }



    @DeleteMapping("/{id}")
    public void excluirMoto(@PathVariable Long id) {
        if (!motoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }

        motoRepository.deleteById(id);
    }


    @GetMapping("/{id}")
    public Moto consultarMotoPorId(@PathVariable Long id) {
        return motoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada"));
    }


}
