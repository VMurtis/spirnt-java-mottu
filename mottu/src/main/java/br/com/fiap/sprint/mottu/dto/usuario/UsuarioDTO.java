package br.com.fiap.sprint.mottu.dto.usuario;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank
        String email,

        @NotBlank
        String cpf,

        @NotBlank
        String telefone,

        @NotBlank
        String user_name,

        @NotBlank
        String password_hash,

        Long filialid
) {
}
