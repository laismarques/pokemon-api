package com.lais.pokemon_api.domain.model;

import java.util.List;

public class User {
    private String name;
    private String email;
    private List<String> favoritePokemonNames;

    public User(List<String> favoritePokemonNames, String name, String email) {
        this.favoritePokemonNames = favoritePokemonNames;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getFavoritePokemonNames() {
        return favoritePokemonNames;
    }

    public void setFavoritePokemonNames(List<String> favoritePokemonNames) {
        this.favoritePokemonNames = favoritePokemonNames;
    }
}
