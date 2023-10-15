package ru.raiffeisen.dgtl.Shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SockDto {

    @JsonProperty(value = "Color")
    @NotEmpty(message = "Field can't be empty")
    private String color;

    @JsonProperty(value = "Cotton part")
    @NotNull(message = "Field can't be empty")
    private Integer cottonPart;

    @JsonProperty(value = "Quantity")
    @NotNull(message = "Field can't be empty")
    private Integer quantity;
}
