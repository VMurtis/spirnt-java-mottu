package br.com.fiap.sprint.mottu.dto.motoLog;

import br.com.fiap.sprint.mottu.entity.MotoLog;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record MotoLogGetDTO(

        Long id,
        Date data_hora,


        String localizacao,


        String status_atual
) {
    public MotoLogGetDTO(MotoLog motoLog) {
        this(motoLog.getId(),motoLog.getData_hora(),motoLog.getLocalizacao(), motoLog.getStatus_atual());
    }
}
