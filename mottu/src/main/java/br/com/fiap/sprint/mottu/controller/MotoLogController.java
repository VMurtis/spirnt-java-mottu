package br.com.fiap.sprint.mottu.controller;

import br.com.fiap.sprint.mottu.dto.layoutsFilial.LayoutsFilialDTO;
import br.com.fiap.sprint.mottu.dto.moto.MotoDTO;
import br.com.fiap.sprint.mottu.dto.motoLog.MotoLogDTO;
import br.com.fiap.sprint.mottu.entity.LayoutsFilial;
import br.com.fiap.sprint.mottu.entity.Moto;
import br.com.fiap.sprint.mottu.entity.MotoLog;
import br.com.fiap.sprint.mottu.repository.MotoLogRepository;
import br.com.fiap.sprint.mottu.repository.MotoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/motoLog")
public class MotoLogController {


    @Autowired
    MotoLogRepository motoLogRepository;


    @GetMapping
    public List<MotoLog> ListartodasMotos(){
        return motoLogRepository.findAll();
    }



    @PostMapping
    public void criarMotoLog(@RequestBody @Valid MotoLogDTO motoLogDTO) {
        MotoLog motoLog = new MotoLog(motoLogDTO);
        motoLogRepository.save(motoLog);
    }

    @PutMapping("/{id}")
    public MotoLog atualizarMotoLog(@PathVariable Long id, @RequestBody @Valid MotoLogDTO motoLogDTO) {
        MotoLog motoLogExistente = motoLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moto log não encontrada"));


        motoLogExistente.setData_hora(motoLogDTO.data_hora());
        motoLogExistente.setLocalizacao(motoLogDTO.localizacao());
        motoLogExistente.setStatus_atual(motoLogDTO.status_atual());

        return motoLogRepository.save(motoLogExistente);
    }



    @DeleteMapping("/{id}")
    public void excluirMotoLog(@PathVariable Long id) {
        if (!motoLogRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto log não encontrada");
        }

        motoLogRepository.deleteById(id);
    }


    @GetMapping("/{id}")
    public MotoLog consultarMotoLogPorId(@PathVariable Long id) {
        return motoLogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada"));
    }
}
