package br.com.fiap.task_management.repository;

import br.com.fiap.task_management.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("from UserModel u where u.email = :email")
    UserModel findByEmail(String email);

}
