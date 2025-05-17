package com.lais.pokemon_api.adapters.persistence.repository;

import java.util.List;

public interface UserRepositoryCustom {
    void addFavorites(String email, List<String> pokemon);
    void deleteByEmail(String email, List<String> pokemon);
    boolean validateFavorite(String email, String pokemonName);
}
