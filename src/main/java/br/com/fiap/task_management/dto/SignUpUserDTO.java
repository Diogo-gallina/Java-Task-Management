package br.com.fiap.task_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpUserDTO(

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "Email não pode ser vazio")
        @Size(max = 150, message = "Email deve ter no máximo 100 caracteres")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Senha não pode ser vazia")
        @Size(max = 100, message = "Senha deve ter no máximo 100 caracteres")
        String password

) {
}
