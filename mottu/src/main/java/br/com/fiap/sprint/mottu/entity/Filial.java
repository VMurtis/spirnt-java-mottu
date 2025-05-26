package br.com.fiap.sprint.mottu.entity;


import br.com.fiap.sprint.mottu.dto.filial.FilialDTO;
import jakarta.persistence.*;
import br.com.fiap.sprint.mottu.annotations.Coluna;


import java.util.Date;
import java.util.List;


@Entity
@Table(name="TB_filial")
@SequenceGenerator(name = "filial_seq", sequenceName = "filial_seq", allocationSize = 1)
public class Filial {

    @Id
    @Column(name = "cd_filial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filial_seq")
    private Long id;

    @Column(name = "filial_name", nullable = false, length = 100)
    @Coluna(nome = "filial_name", tamanho = 100, obrigatorio = true)
    private String filialName;

    @Column(name = "endereco", nullable = false, length = 100)
    @Coluna(nome = "endereco", tamanho = 100, obrigatorio = true)
    private String endereco;

    @Column(name = "contato", nullable = false, length = 100)
    @Coluna(nome = "contato", tamanho = 100, obrigatorio = true)
    private String contato;


    @Column(name = "horario_funcionamento", nullable = false, length = 100)
    @Coluna(nome = "horario_funcionamento", tamanho = 100, obrigatorio = true)
    private String horario_funcionamento;



    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    @OneToOne
    @JoinColumn(name="layout_id")
    private LayoutsFilial layoutsFilial;

    //@OneToMany(mappedBy = "filial")
    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    //@OneToMany(mappedBy = "usuario")
    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Moto> motos;




    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilialName() {
        return filialName;
    }

    public void setFilialName(String filialName) {
        this.filialName = filialName;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LayoutsFilial getLayoutsFilial() {
        return layoutsFilial;
    }

    public void setLayoutsFilial(LayoutsFilial layoutsFilial) {
        this.layoutsFilial = layoutsFilial;
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setMoto(List<Moto> moto) {
        this.motos = motos;
    }

    public Filial() {
    }


    public Filial(Long id, String filialName, String endereco, String contato, String horario_funcionamento) {
        this.id = id;
        this.filialName = filialName;
        this.endereco = endereco;
        this.contato = contato;
        this.horario_funcionamento = horario_funcionamento;
    }

    public Filial(FilialDTO dto) {
        this.filialName = dto.filial_name();
        this.endereco = dto.endereco();
        this.contato = dto.contato();
        this.layoutsFilial.setId(dto.layoutId());
        this.usuarios = dto.usuarios();
        this.motos = dto.motos();

    }

    public Filial(Long id, String filialName, String endereco, String contato, String horario_funcionamento, LayoutsFilial layoutsFilial, List<Usuario> usuarios, List<Moto> moto) {
        this.id = id;
        this.filialName = filialName;
        this.endereco = endereco;
        this.contato = contato;
        this.horario_funcionamento = horario_funcionamento;
        this.layoutsFilial = layoutsFilial;
        this.usuarios = usuarios;
        this.motos = moto;
    }
}
