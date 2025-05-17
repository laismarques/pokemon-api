package com.lais.pokemon_api.adapters.web;


import com.lais.pokemon_api.adapters.pokeapi.dto.PokeApiResponseDto;
import com.lais.pokemon_api.application.dto.PokemonSummaryDto;
import com.lais.pokemon_api.application.usecases.PokemonUseCase;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonUseCase pokemonUseCase;

    public PokemonController(PokemonUseCase pokemonUseCase) {
        this.pokemonUseCase = pokemonUseCase;

    }


    @GetMapping()
    public ResponseEntity<PokemonSummaryDto> listAll(
            @RequestParam(name = "orderBy", defaultValue = "asc") String orderBy,
            @RequestParam(name = "limit", defaultValue = "20") Integer limit,
            @RequestParam(name = "offset", defaultValue = "0") Integer offset) {
        System.out.println(orderBy);
        PokemonSummaryDto response = pokemonUseCase.listAll(orderBy, limit, offset);
        return ResponseEntity.ok(response);
    }
}
