package ru.raiffeisen.dgtl.Shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.raiffeisen.dgtl.Shop.entity.CompareOperations;
import ru.raiffeisen.dgtl.Shop.entity.SockColors;

@Getter
@Setter
public class SockDto {

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "Color")
    private SockColors color;

    @Enumerated
    @JsonProperty(value = "Operation")
    private CompareOperations operation;

    @Column(name = "cottonPart")
    @Min(value = 0, message = "")
    @Max(value = 100, message = "")
    @JsonProperty(value = "Cotton Part")
    private int cottonPart;

}
