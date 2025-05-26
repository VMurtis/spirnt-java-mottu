package br.com.fiap.sprint.mottu.dto.filial;



import br.com.fiap.sprint.mottu.entity.Filial;
import br.com.fiap.sprint.mottu.entity.Usuario;
import br.com.fiap.sprint.mottu.entity.Moto;



import java.util.Date;
import java.util.List;

public record FilialGetDTO(

        Long id,

        String filial_name,

        String endereco,

        String contato,

        String horario_funcionamento,

        Long layoutId,

        List<Long> usuariosId,

        List<Long> motosId
) {
    public FilialGetDTO(Filial filial) {
        this(
                filial.getId(),
                filial.getFilialName(),
                filial.getEndereco(),
                filial.getContato(),
                filial.getHorario_funcionamento(),
                filial.getLayoutsFilial() != null ? filial.getLayoutsFilial().getId() : null,
                filial.getUsuarios() != null ?
                        filial.getUsuarios().stream().map(Usuario::getId).toList() :
                        List.of(),
                filial.getMotos() != null ?
                        filial.getMotos().stream().map(Moto::getIdMoto).toList() :
                        List.of()
        );
    }


}
