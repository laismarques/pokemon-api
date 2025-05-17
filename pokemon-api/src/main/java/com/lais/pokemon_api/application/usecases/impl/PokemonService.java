package com.lais.pokemon_api.application.usecases.impl;

import com.lais.pokemon_api.adapters.pokeapi.dto.PokeSummaryDto;
import com.lais.pokemon_api.application.dto.PokemonSummaryDto;
import com.lais.pokemon_api.application.usecases.PokemonUseCase;
import com.lais.pokemon_api.domain.gatway.ExternalGatway;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PokemonService implements PokemonUseCase {

    private final ExternalGatway externalGatway;
    private List<String> pokemonsCacheName;

    public PokemonService(ExternalGatway externalGatway,
                          List<String> pokemonsCacheName) {
        this.externalGatway = externalGatway;
        this.pokemonsCacheName = pokemonsCacheName;
    }


    @PostConstruct
    public void loadPokemonsName() {
        refreshCache();
    }

    @Scheduled(fixedRate = 6 * 60 * 60 * 1000)
    public void refreshCache() {
        this.pokemonsCacheName = externalGatway.listAll().results()
                .stream().map(PokeSummaryDto::name).sorted().toList();
        System.out.println("Cache updated at: " + LocalDateTime.now());
        System.out.println("Size of cache: " + pokemonsCacheName.size());
    }

    @Override
    public PokemonSummaryDto listAll(String orderBy, Integer limit, Integer offset) {
        System.out.println(this.pokemonsCacheName);


        if ("desc".equalsIgnoreCase(orderBy)){
            List<String> orderNames = this.pokemonsCacheName.stream().sorted(Comparator.reverseOrder())
                    .skip(offset).limit(limit).toList();
            return new PokemonSummaryDto(this.pokemonsCacheName.size(), orderNames);
        }
        List<String> orderNames = this.pokemonsCacheName.stream().sorted(Comparator.naturalOrder())
                .skip(offset).limit(limit).toList();

        return new PokemonSummaryDto(this.pokemonsCacheName.size(), orderNames);
    }
}
