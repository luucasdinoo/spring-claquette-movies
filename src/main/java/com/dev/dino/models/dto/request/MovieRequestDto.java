package com.dev.dino.models.dto.request;

import com.dev.dino.models.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDto {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    private Category category;
    @NotNull
    @NotBlank
    private String whereToWatch;

}
