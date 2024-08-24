package br.com.fiap.task_management.model;

import br.com.fiap.task_management.model.enunms.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "CP1_JV_2TDSS_TASK")
@EntityListeners(AuditingEntityListener.class)
public class TaskModel {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 700)
    private String description;

    @Column(name = "status", nullable = false, length = 700)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

}
