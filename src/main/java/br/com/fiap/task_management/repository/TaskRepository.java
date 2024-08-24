package br.com.fiap.task_management.repository;

import br.com.fiap.task_management.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
