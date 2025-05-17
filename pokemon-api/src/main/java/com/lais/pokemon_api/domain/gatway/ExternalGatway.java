package com.lais.pokemon_api.domain.gatway;

import com.lais.pokemon_api.adapters.pokeapi.dto.PokeApiResponseDto;
import com.lais.pokemon_api.adapters.pokeapi.dto.PokeDetailDto;

public interface ExternalGatway {
    PokeApiResponseDto listAll();
    PokeDetailDto getDetails(String pokemonName);

}
