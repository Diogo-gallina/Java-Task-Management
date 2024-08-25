package br.com.fiap.task_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {

    @GetMapping("/status")
    public ResponseEntity<PossibleTaskStatusDTO> findTaskStatus() {
        return ResponseEntity.ok().body(new PossibleTaskStatusDTO());
    }
}
