package com.lais.pokemon_api.domain.gatway;

import com.lais.pokemon_api.adapters.pokeapi.dto.PokeApiResponseDto;

public interface ExternalGatway {
    PokeApiResponseDto listAll();

}
