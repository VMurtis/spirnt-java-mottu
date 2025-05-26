package br.com.fiap.sprint.mottu.entity;

import br.com.fiap.sprint.mottu.annotations.Coluna;
import br.com.fiap.sprint.mottu.dto.filial.FilialDTO;
import br.com.fiap.sprint.mottu.dto.layoutsFilial.LayoutsFilialDTO;
import jakarta.persistence.*;

@Entity
@Table(name="TB_layoutsfilial")
@SequenceGenerator(name = "layoutsfilial_seq", sequenceName = "layoutsfilial_seq", allocationSize = 1)
public class LayoutsFilial {
    @Id
    @Column(name="cd_Layouts_filial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "layouts_seq")
    private Long id;


    @Coluna(nome="info_layout")
    @Column(nullable = false, length = 100)
    private String infoLayout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo_layout() {
        return infoLayout;
    }

    public void setInfo_layout(String info_layout) {
        this.infoLayout = info_layout;
    }



    public LayoutsFilial() {
    }

    public LayoutsFilial(Long id, String infoLayout) {
        this.id = id;
        this.infoLayout = infoLayout;
    }

    public LayoutsFilial(LayoutsFilialDTO dto) {
        this.infoLayout = dto.info_layout();
    }


}