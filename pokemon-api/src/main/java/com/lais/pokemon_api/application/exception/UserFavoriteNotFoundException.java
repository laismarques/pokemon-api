package com.lais.pokemon_api.application.exception;

public class UserFavoriteNotFoundException extends RuntimeException {
    public UserFavoriteNotFoundException() {
        super("User favorite not found");
    }
}
