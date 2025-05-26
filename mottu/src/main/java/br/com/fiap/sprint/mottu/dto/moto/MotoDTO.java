package br.com.fiap.sprint.mottu.dto.moto;



import jakarta.validation.constraints.NotNull;
import br.com.fiap.sprint.mottu.entity.enums.TipoMoto;

public record MotoDTO(
        @NotNull
        String modelo,

        @NotNull
        String placa,

        @NotNull
        String chassi,


        @NotNull
        String iot_info,

        @NotNull
        String rfid_tag,

        @NotNull
        String localizacao,

        @NotNull
        String status_atual,


        Long motoLogId,


        Long filialId,
        @NotNull
        TipoMoto tipoMoto
) {
}
