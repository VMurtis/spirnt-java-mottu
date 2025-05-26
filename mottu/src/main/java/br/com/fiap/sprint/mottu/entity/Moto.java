package br.com.fiap.sprint.mottu.entity;


import br.com.fiap.sprint.mottu.dto.moto.MotoDTO;
import br.com.fiap.sprint.mottu.entity.enums.TipoMoto;
import jakarta.persistence.*;
import br.com.fiap.sprint.mottu.annotations.Coluna;

@Entity
@Table(name="TB_moto")
@SequenceGenerator(name = "moto_seq", sequenceName = "moto_seq", allocationSize = 1)
public class Moto {

    @Id
    @Column(name="cd_moto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    private Long idMoto;



    @Coluna(nome="placa")
    @Column(nullable = false, length = 100)
    private String placa;

    @Coluna(nome="chassi")
    @Column(nullable = false, length = 100)
    private String chassi;

    @ManyToOne
    @JoinColumn(name = "cd_user")
    private Usuario user;

    @Coluna(nome="iot_info")
    @Column(nullable = false, length = 100)
    private String iot_info;

    @Coluna(nome="rfid_tag")
    @Column(nullable = false, length = 100)
    private String rfid_tag;

    @Coluna(nome="localizacao")
    @Column(nullable = false, length = 100)
    private String localizacao;

    @Coluna(nome="status_atual")
    @Column(nullable = false, length = 100)
    private String status_atual;

    @Coluna(nome="id_filial")
    @Column(nullable = false, length = 100)
    private String id_filial;

    @OneToOne
    @JoinColumn(name="moto_log_id")
    private MotoLog motolog;

    @ManyToOne
    @JoinColumn(name = "usuario_id")  // Chave estrangeira
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filial_id") // nome da coluna no banco,
    private Filial filial;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_modelo", nullable = false)
    private TipoMoto tipoMoto;





    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(TipoMoto tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public MotoLog getMotolog() {
        return motolog;
    }

    public void setMotolog(MotoLog motolog) {
        this.motolog = motolog;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Moto(MotoDTO dto) {

        this.placa = dto.placa();
        this.chassi = dto.chassi();
        this.iot_info = dto.iot_info();
        this.rfid_tag = dto.rfid_tag();
        this.localizacao = dto.localizacao();
        this.status_atual = dto.status_atual();
        this.tipoMoto = dto.tipoMoto();
    }
    public Moto(MotoDTO dto, Filial filial) {
    }


    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }





    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getIot_info() {
        return iot_info;
    }

    public void setIot_info(String iot_info) {
        this.iot_info = iot_info;
    }

    public String getRfid_tag() {
        return rfid_tag;
    }

    public void setRfid_tag(String rfid_tag) {
        this.rfid_tag = rfid_tag;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus_atual() {
        return status_atual;
    }

    public void setStatus_atual(String status_atual) {
        this.status_atual = status_atual;
    }

    public String getId_filial() {
        return id_filial;
    }

    public void setId_filial(String id_filial) {
        this.id_filial = id_filial;
    }

    public Moto() {
    }


    public Moto(Long idMoto, String placa, String chassi, Usuario user, String iot_info, String rfid_tag, String localizacao, String status_atual, String id_filial, MotoLog motolog, Usuario usuario, Filial filial, TipoMoto tipoMoto) {
        this.idMoto = idMoto;
        this.placa = placa;
        this.chassi = chassi;
        this.user = user;
        this.iot_info = iot_info;
        this.rfid_tag = rfid_tag;
        this.localizacao = localizacao;
        this.status_atual = status_atual;
        this.id_filial = id_filial;
        this.motolog = motolog;
        this.usuario = usuario;
        this.filial = filial;
        this.tipoMoto = tipoMoto;
    }
}
