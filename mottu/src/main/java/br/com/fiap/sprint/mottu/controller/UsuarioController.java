package br.com.fiap.sprint.mottu.controller;

import br.com.fiap.sprint.mottu.dto.motoLog.MotoLogDTO;
import br.com.fiap.sprint.mottu.dto.usuario.UsuarioDTO;
import br.com.fiap.sprint.mottu.entity.MotoLog;
import br.com.fiap.sprint.mottu.entity.Usuario;
import br.com.fiap.sprint.mottu.repository.UsuarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping
    public List<Usuario> ListartodosUsuario(){
        return usuarioRepository.findAll();
    }



    @PostMapping
    public void criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));

        usuarioExistente.setEmail(usuarioDTO.email());
        usuarioExistente.setCpf(usuarioDTO.cpf());
        usuarioExistente.setTelefone(usuarioDTO.telefone());
        usuarioExistente.setNome(usuarioDTO.user_name());
        usuarioExistente.setPassword_hash(usuarioDTO.password_hash());


        return usuarioRepository.save(usuarioExistente);
    }



    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado");
        }

        usuarioRepository.deleteById(id);
    }


    @GetMapping("/{id}")
    public Usuario consultarUsuarioPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }
}
