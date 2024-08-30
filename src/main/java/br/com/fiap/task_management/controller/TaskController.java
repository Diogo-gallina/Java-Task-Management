package br.com.fiap.task_management.controller;

import br.com.fiap.task_management.dto.task.CreateTaskDTO;
import br.com.fiap.task_management.dto.task.TaskDetailsDTO;
import br.com.fiap.task_management.dto.task.UpdateTaskDTO;
import br.com.fiap.task_management.model.TaskModel;
import br.com.fiap.task_management.repository.TaskRepository;
import br.com.fiap.task_management.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<TaskDetailsDTO> create(@AuthenticationPrincipal UserDetails userDetails,
                                                 @RequestBody @Valid CreateTaskDTO dto,
                                                  UriComponentsBuilder uriBuilder) {
            var user = userRepository.findByEmail(userDetails.getUsername());
            var task = new TaskModel(dto, user);
            taskRepository.save(task);
            var uri = uriBuilder.path("/tasks/{task_id}")
                    .buildAndExpand(user.getId(), task.getId()).toUri();
            return ResponseEntity.created(uri).body(new TaskDetailsDTO(task));
    }

    @GetMapping()
    public ResponseEntity<Page<TaskDetailsDTO>> findAll(@AuthenticationPrincipal UserDetails userDetails,
                                                        Pageable page) {
        var user = userRepository.findByEmail(userDetails.getUsername());

        var tasks = taskRepository.findAllByUserId(user.getId(), page).map(TaskDetailsDTO::new);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDetailsDTO> update(@AuthenticationPrincipal UserDetails userDetails,
                                                 @RequestBody @Valid UpdateTaskDTO dto,
                                                 @PathVariable("taskId") Long taskId) {
        var user = userRepository.findByEmail(userDetails.getUsername());
        var task = user.getTasks().stream().filter(t-> t.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED"));
        task.update(dto);
        taskRepository.save(task);
        return ResponseEntity.ok(new TaskDetailsDTO(task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> delete(@AuthenticationPrincipal UserDetails userDetails,
                                       @PathVariable("taskId") Long taskId) {
        var user = userRepository.findByEmail(userDetails.getUsername());
        var task = user.getTasks().stream().filter(t-> t.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED"));
        taskRepository.deleteById(task.getId());
        return ResponseEntity.noContent().build();
    }
}
