package br.com.fiap.sprint.mottu.dto.layoutsFilial;

import jakarta.validation.constraints.NotBlank;


public record LayoutsFilialDTO(
        @NotBlank
        String info_layout
) {


}
