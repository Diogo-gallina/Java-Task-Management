package br.com.fiap.task_management.controller;

import br.com.fiap.task_management.model.enunms.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("public")
public class PublicController {

    @GetMapping("/status")
    public ResponseEntity<List<Status>> findTaskStatus() {
        return ResponseEntity.ok(Arrays.asList(Status.values()));
    }
}
