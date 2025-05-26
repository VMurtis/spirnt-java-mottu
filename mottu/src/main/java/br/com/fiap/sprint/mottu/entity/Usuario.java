package br.com.fiap.sprint.mottu.entity;

import br.com.fiap.sprint.mottu.annotations.Coluna;
import br.com.fiap.sprint.mottu.dto.motoLog.MotoLogDTO;
import br.com.fiap.sprint.mottu.dto.usuario.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table(name="TB_usuario")
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
public class Usuario {

    @Id
    @Column(name="cd_user")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    private Long id;

    @Coluna(nome="nome")
    @Column(name = "nome_usuario", unique = true, nullable = false, length = 25)
    private String nome;



    @Coluna(nome="email")
    @Column(nullable = false, length = 100)
    private String email;

    @Coluna(nome="cpf")
    @Column(nullable = false, length = 11)
    private String cpf;

    @Coluna(nome="telefone")
    @Column(nullable = false, length = 100)
    private String telefone;

    @Coluna(nome="user_name")
    @Column(nullable = false, length = 100)
    private String user_name;

    @Coluna(nome="password_hash")
    @Column(nullable = false, length = 100)
    private String password_hash;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "filial_id")  // Chave estrangeira no banco
    private Filial filial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }


    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String cpf, String telefone, String user_name, String password_hash, Filial filial) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.user_name = user_name;
        this.password_hash = password_hash;
        this.filial = filial;
    }

    public Usuario(UsuarioDTO dto) {
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.telefone = dto.telefone();
        this.nome = dto.user_name();
        this.password_hash = dto.password_hash();


    }



}
