package br.com.fiap.sprint.mottu.dto.usuario;

import br.com.fiap.sprint.mottu.entity.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioGetDTO(
        Long id,


        String email,


        String cpf,


        String telefone,

        String user_name,

        String password_hash,
        Long filialId
) {
    public UsuarioGetDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPassword_hash(), usuario.getCpf(), usuario.getTelefone(),usuario.getFilial().getId());
    }
}
