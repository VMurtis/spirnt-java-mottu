package br.com.fiap.sprint.mottu.dto.moto;

import br.com.fiap.sprint.mottu.entity.Filial;
import br.com.fiap.sprint.mottu.entity.Moto;
import br.com.fiap.sprint.mottu.entity.MotoLog;
import br.com.fiap.sprint.mottu.entity.Usuario;
import br.com.fiap.sprint.mottu.entity.enums.TipoMoto;

public record MotoGetDTO(

        Long id,


        String placa,

        String chassi,


        String iot_info,

        String rfid_tag,

        String localizacao,

        String status_atual,
        Long motoLogId,
        Long usuarioId,
        Long filialId,
        TipoMoto tipoMoto
) {
    public MotoGetDTO(Moto moto) {
        this(moto.getIdMoto(), moto.getPlaca(), moto.getChassi(), moto.getIot_info(), moto.getRfid_tag(),moto.getLocalizacao(), moto.getStatus_atual(),moto.getMotolog() != null ? moto.getMotolog().getId() : null,
                moto.getUsuario() != null ? moto.getUsuario().getId() : null,
                moto.getFilial() != null ? moto.getFilial().getId() : null,
                moto.getTipoMoto());
    }


}
