package br.com.fiap.task_management.dto.user;

import br.com.fiap.task_management.model.UserModel;

public record UserDetailsDTO(
        Long id,
        String name,
        String email
) {
    public UserDetailsDTO (UserModel user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

}
