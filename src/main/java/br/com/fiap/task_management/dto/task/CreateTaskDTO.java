package br.com.fiap.task_management.dto.task;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateTaskDTO(

    @NotBlank(message = "Título não pode ser vazio")
    @Size(max = 100, message = "Título deve ter no máximo 100 caracteres")
    String title,

    @NotBlank(message = "Descrição não pode ser vazia")
    @Size(max = 700, message = "Descrição deve ter no máximo 700 caracteres")
    String description,

    @NotNull(message = "Data de conclusão prevista não pode ser nula")
    @Future(message = "Data de conclusão prevista não pode ser uma data do passado")
    LocalDateTime expectedCompletionDate
) {
}
