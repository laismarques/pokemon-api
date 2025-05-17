package com.lais.pokemon_api.adapters.pokeapi.client;

import com.lais.pokemon_api.adapters.pokeapi.dto.PokeApiResponseDto;
import com.lais.pokemon_api.adapters.pokeapi.dto.PokeDetailDto;
import com.lais.pokemon_api.domain.gatway.ExternalGatway;
import org.springframework.stereotype.Component;


@Component
public class PokeGatewayAdapter implements ExternalGatway {

    private final PokeApiClient apiClient;

    public PokeGatewayAdapter(PokeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public PokeApiResponseDto listAll(){
        return apiClient.listAll();
    }

    @Override
    public PokeDetailDto getDetails(String pokemonName){
        return apiClient.getPokemonDetail(pokemonName);
    }
}
