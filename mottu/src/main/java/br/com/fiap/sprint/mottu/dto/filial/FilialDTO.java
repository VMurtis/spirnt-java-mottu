package br.com.fiap.sprint.mottu.dto.filial;


import br.com.fiap.sprint.mottu.entity.Moto;
import br.com.fiap.sprint.mottu.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.Date;
import java.util.List;

public record FilialDTO(
        @NotNull(message = "O nome da filial é obrigatório")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        String filial_name,
        @NotNull
        String endereco,
        @NotNull
        String contato,



        String horario_funcionamento,

        Long layoutId,

        List<Usuario> usuarios,

        List<Moto> motos

) {




}
