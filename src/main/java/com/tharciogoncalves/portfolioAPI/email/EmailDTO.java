package com.tharciogoncalves.portfolioAPI.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailDTO(@NotBlank(message = "Campo Nome é obrigatório") String name,
                       @NotBlank(message = "Campo Assunto obrigatório")
                       @Max(value = 15, message = "Campo Assunto deve ter no máximo 15 caracteres")
                       String subject,
                       @NotBlank(message = "Campo Mensagem obrigatório") String message,
                       @NotBlank(message = "Campo Email é obrigatório")
                       @Email(message = "Formato de emailFrom inválido") String emailFrom,
                       @NotBlank(message = "Campo EmailTo é obrigatório")
                       @NotNull(message = "Campo EmailTo é obrigatório")
                       @Email(message = "Formato de email inválido") String emailTo) {
}
