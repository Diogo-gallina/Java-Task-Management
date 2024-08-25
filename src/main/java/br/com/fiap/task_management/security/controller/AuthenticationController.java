package br.com.fiap.task_management.security.controller;

import br.com.fiap.task_management.model.UserModel;
import br.com.fiap.task_management.security.dto.AuthenticationDataDTO;
import br.com.fiap.task_management.security.dto.TokenDataJwtDTO;
import br.com.fiap.task_management.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<TokenDataJwtDTO> login(@RequestBody AuthenticationDataDTO loginData){
        var token = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
        var authentication = manager.authenticate(token);
        var tokenJwt = tokenService.gerarToken((UserModel) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDataJwtDTO(tokenJwt));
    }
}