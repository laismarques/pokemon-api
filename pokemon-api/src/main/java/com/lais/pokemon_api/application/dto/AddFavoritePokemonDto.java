package com.lais.pokemon_api.application.dto;

import java.util.List;

public class AddFavoritePokemonDto {
    private List<String> favoritePokemonsName;

    public AddFavoritePokemonDto(List<String> favoritePokemonsName) {
        this.favoritePokemonsName = favoritePokemonsName;
    }

    public List<String> getFavoritePokemonsName() {
        return favoritePokemonsName;
    }

    public void setFavoritePokemonsName(List<String> favoritePokemonsName) {
        this.favoritePokemonsName = favoritePokemonsName;
    }
}
