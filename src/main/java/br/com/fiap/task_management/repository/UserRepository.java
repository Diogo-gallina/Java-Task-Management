package br.com.fiap.task_management.repository;

import br.com.fiap.task_management.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
