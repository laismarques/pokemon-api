package com.lais.pokemon_api.application.usecases.impl;

import com.lais.pokemon_api.adapters.pokeapi.dto.PokeDetailDto;
import com.lais.pokemon_api.adapters.pokeapi.dto.PokeSummaryDto;
import com.lais.pokemon_api.application.dto.AddFavoritePokemonDto;
import com.lais.pokemon_api.application.dto.PokemonDetailsDto;
import com.lais.pokemon_api.application.dto.PokemonSummaryDto;
import com.lais.pokemon_api.application.dto.UserFavoritePokemonDto;
import com.lais.pokemon_api.application.mappers.PokemonDetailsMapper;
import com.lais.pokemon_api.application.usecases.PokemonUseCase;
import com.lais.pokemon_api.domain.gatway.ExternalGatway;
import com.lais.pokemon_api.domain.gatway.RepostoryGatway;
import com.lais.pokemon_api.domain.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PokemonService implements PokemonUseCase {

    private List<String> pokemonsCacheName;
    private final ExternalGatway externalGatway;
    private final RepostoryGatway repostoryGatway;
    private final PokemonDetailsMapper pokemonDetailsMapper;

    public PokemonService(ExternalGatway externalGatway, RepostoryGatway repostoryGatway, PokemonDetailsMapper pokemonDetailsMapper) {
        this.externalGatway = externalGatway;
        this.repostoryGatway = repostoryGatway;
        this.pokemonDetailsMapper = pokemonDetailsMapper;
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

    public List<String> sortFavoritePokemons(List<String> names, String orderBy){
        if (orderBy.equalsIgnoreCase("desc")){
            return names.stream().sorted(Comparator.reverseOrder()).toList();
        }
        return names.stream().sorted(Comparator.naturalOrder()).toList();
    }

    @Override
    public void save(User user) {
        repostoryGatway.save(user);
    }

    @Override
    public UserFavoritePokemonDto getFavorites(String email, String orderBy){
        List<String> favoritePokemonNames = repostoryGatway.getFavorites(email);

       return new UserFavoritePokemonDto(sortFavoritePokemons(favoritePokemonNames, orderBy));
    }

    @Override
    public void addFavorites(String email, AddFavoritePokemonDto favoritePokemons){

        repostoryGatway.addFavorites(email, favoritePokemons.getFavoritePokemonsName());
    }

    @Override
    public void delete(String email, List<String> pokemon){
        repostoryGatway.delete(email, pokemon);
    }

    @Override
    public boolean userExists(String email){
        return repostoryGatway.userExists(email);
    }

    @Override
    public PokemonDetailsDto getDetails(String pokemonName){
        PokeDetailDto pokemonDetailResponse = externalGatway.getDetails(pokemonName);
        return  pokemonDetailsMapper.toDetailsDto(pokemonDetailResponse);
    }

    @Override
    public boolean validateFavorite(String email, String name){
        return repostoryGatway.validateFavorite(email, name);
    }

}
