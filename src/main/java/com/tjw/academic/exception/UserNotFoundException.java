package com.tjw.academic.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("Não foi possivel encontrar o usuário com o id igual a %s.", id));
    }
}
