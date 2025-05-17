package com.lais.pokemon_api.application.usecases;

import com.lais.pokemon_api.application.dto.AddFavoritePokemonDto;
import com.lais.pokemon_api.application.dto.PokemonDetailsDto;
import com.lais.pokemon_api.application.dto.PokemonSummaryDto;
import com.lais.pokemon_api.application.dto.UserFavoritePokemonDto;
import com.lais.pokemon_api.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface PokemonUseCase {


    PokemonSummaryDto listAll(String orderBy, Integer limit, Integer offset);

    void save(User user);
    UserFavoritePokemonDto getFavorites(String email, String orderBy);
    void addFavorites(String email, AddFavoritePokemonDto favoritePokemonDto);
    void delete(String email, List<String> pokemon);
    boolean validateFavorite(String email, String pokemonName);
    PokemonDetailsDto getDetails(String pokemonName);

    boolean userExists(String email);
}
