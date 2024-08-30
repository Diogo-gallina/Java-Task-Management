package br.com.fiap.task_management.dto.task;

import br.com.fiap.task_management.model.TaskModel;
import br.com.fiap.task_management.model.enunms.Status;

import java.time.LocalDateTime;

public record TaskDetailsDTO(
        Long taskId,
        Long userId,
        String title,
        String description,
        LocalDateTime expectedCompletionDate,
        Status status
) {
    public TaskDetailsDTO(TaskModel task){
        this(
                task.getId(),
                task.getUser().getId(),
                task.getTitle(),
                task.getDescription(),
                task.getExpectedCompletionDate(),
                task.getStatus()
        );
    }
}
