package com.cars.api.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record CarDTO(

        @NotBlank String modelo,

        @NotBlank String fabricante,

        @Past String dataFabricacao,

        @NotBlank Integer valor,

        @Pattern(regexp = "^[0-9]{2}$") @NotNull Integer anoModelo) {

}
