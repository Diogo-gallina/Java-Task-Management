package br.com.fiap.task_management.controller;

import br.com.fiap.task_management.dto.user.SignUpUserDTO;
import br.com.fiap.task_management.dto.user.UserDetailsDTO;
import br.com.fiap.task_management.model.UserModel;
import br.com.fiap.task_management.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<UserDetailsDTO> signup(@RequestBody @Valid SignUpUserDTO dto, UriComponentsBuilder uriBuilder) {
        var user = new UserModel(dto.name(), dto.email(), passwordEncoder.encode(dto.password()));
        userRepository.save(user);
        var url = uriBuilder.path("/user/signup/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(new UserDetailsDTO(user));
    }

}
