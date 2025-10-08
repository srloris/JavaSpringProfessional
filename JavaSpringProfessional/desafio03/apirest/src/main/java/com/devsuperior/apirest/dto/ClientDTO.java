package com.devsuperior.apirest.dto;

import com.devsuperior.apirest.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;
    @NotBlank(message = "Fill in the name field")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Invalid Date")
    private LocalDate birthDate;
    private Integer children;

}
