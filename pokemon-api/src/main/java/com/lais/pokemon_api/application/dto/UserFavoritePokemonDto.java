package com.lais.pokemon_api.application.dto;

import java.util.List;

public class UserFavoritePokemonDto {
    List<String> favoritePokemonNames;

    public UserFavoritePokemonDto(List<String> favoritePokemonNames) {
        this.favoritePokemonNames = favoritePokemonNames;
    }

    public List<String> getFavoritePokemonNames() {
        return favoritePokemonNames;
    }

    public void setFavoritePokemonNames(List<String> favoritePokemonNames) {
        this.favoritePokemonNames = favoritePokemonNames;
    }
}
