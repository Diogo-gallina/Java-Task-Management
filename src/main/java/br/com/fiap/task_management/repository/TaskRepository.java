package br.com.fiap.task_management.repository;

import br.com.fiap.task_management.model.TaskModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    @Query("from TaskModel t where t.user.id = :userId")
    Page<TaskModel> findAllByUserId(Long userId, Pageable page);

}
