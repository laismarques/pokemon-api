package com.lais.pokemon_api.adapters.pokeapi.client;


import com.lais.pokemon_api.adapters.pokeapi.dto.PokeApiResponseDto;
import com.lais.pokemon_api.adapters.pokeapi.dto.PokeDetailDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "pokemonApi",
        url = "https://pokeapi.co/api/v2"
)
public interface PokeApiClient {

    @GetMapping("/pokemon?limit=10000")
    PokeApiResponseDto listAll();

    @GetMapping("/pokemon/{name}")
    PokeDetailDto getPokemonDetail(@PathVariable String name);
}
