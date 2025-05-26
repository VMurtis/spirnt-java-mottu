package br.com.fiap.sprint.mottu.entity;

import br.com.fiap.sprint.mottu.dto.moto.MotoDTO;
import br.com.fiap.sprint.mottu.dto.motoLog.MotoLogDTO;
import br.com.fiap.sprint.mottu.dto.usuario.UsuarioDTO;
import jakarta.persistence.*;
import br.com.fiap.sprint.mottu.annotations.Coluna;
import java.util.Date;


@Entity
@Table(name="TB_moto_log")
@SequenceGenerator(name = "moto_log_seq", sequenceName = "moto_log_seq", allocationSize = 1)
public class MotoLog {

    @Id
    @Column(name="cd_log")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_log_seq")
    private Long id;


    @Temporal(TemporalType.TIMESTAMP)
    @Coluna(nome="data_hora")
    @Column(name = "horario_funcionamento",nullable = false, length = 100)
    private Date data_hora;

    @Coluna(nome="localizacao")
    @Column(nullable = false, length = 100)
    private String localizacao;

    @Coluna(nome="status_atual")
    @Column(nullable = false, length = 100)
    private String status_atual;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
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



    public MotoLog() {
    }

    public MotoLog(Long id, Date data_hora, String localizacao, String status_atual) {
        this.id = id;
        this.data_hora = data_hora;
        this.localizacao = localizacao;
        this.status_atual = status_atual;
    }

    public MotoLog(MotoLogDTO dto) {
        this.data_hora = dto.data_hora();
        this.localizacao = dto.localizacao();
        this.status_atual = dto.status_atual();
    }




}
