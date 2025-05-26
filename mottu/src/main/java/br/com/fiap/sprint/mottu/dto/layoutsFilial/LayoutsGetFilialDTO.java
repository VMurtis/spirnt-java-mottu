package br.com.fiap.sprint.mottu.dto.layoutsFilial;

import br.com.fiap.sprint.mottu.entity.LayoutsFilial;

public record LayoutsGetFilialDTO(

        Long id,
        String info_layout
) {
    public LayoutsGetFilialDTO(LayoutsFilial layoutsFilial) {
        this(layoutsFilial.getId(), layoutsFilial.getInfo_layout());
    }
}
