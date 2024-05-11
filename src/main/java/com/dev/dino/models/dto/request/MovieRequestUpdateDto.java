package com.dev.dino.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestUpdateDto {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String description;
}
