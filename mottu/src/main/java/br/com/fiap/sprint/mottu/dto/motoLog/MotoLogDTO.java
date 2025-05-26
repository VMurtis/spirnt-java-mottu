package br.com.fiap.sprint.mottu.dto.motoLog;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record MotoLogDTO(


        Date data_hora,

        @NotNull
        String localizacao,

        @NotNull
        String status_atual
){

}
