package br.com.fiap.task_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "CP1_JV_2TDSS_USER")
@EntityListeners(AuditingEntityListener.class)
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<TaskModel> tasks;

}
