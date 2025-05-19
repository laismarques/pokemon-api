package com.lais.pokemon_api.domain.gatway;

import com.lais.pokemon_api.domain.model.User;

import java.util.List;


public interface RepostoryGatway {

    void save(User user);
    List<String> getFavorites(String email);
    void addFavorites(String email, List<String> favoritePokemons);
    void delete(String email, List<String> pokemon);
    boolean validateFavorite(String email, String pokemonName);
    boolean userExists(String email);
}
