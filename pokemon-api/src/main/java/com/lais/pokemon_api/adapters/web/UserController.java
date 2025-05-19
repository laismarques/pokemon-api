package com.lais.pokemon_api.adapters.web;


import com.lais.pokemon_api.application.dto.AddFavoritePokemonDto;
import com.lais.pokemon_api.application.dto.PokemonDetailsDto;
import com.lais.pokemon_api.application.dto.UserFavoritePokemonDto;
import com.lais.pokemon_api.application.exception.UserNotFoundException;
import com.lais.pokemon_api.application.usecases.PokemonUseCase;
import com.lais.pokemon_api.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    PokemonUseCase useCase;

    public UserController(PokemonUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping()
    public ResponseEntity<String> saveFavorite(
            @RequestBody User user
    ){
        useCase.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/favorites")
    public ResponseEntity<UserFavoritePokemonDto> getFavorite(
            @RequestParam String email,
            @RequestParam(defaultValue = "asc") String orderBy
    ) {

        if (!orderBy.equalsIgnoreCase("asc") && !orderBy.equalsIgnoreCase("desc")){
            throw new IllegalArgumentException("Order by param must be 'asc' or 'desc'");
        }
        UserFavoritePokemonDto pokemons = useCase.getFavorites(email, orderBy);
        return ResponseEntity.ok(pokemons);
    }

    @PostMapping("/favorites")
    public ResponseEntity<String> addFavorites(
            @RequestParam String email,
            @RequestBody AddFavoritePokemonDto favoritePokemons
    ) {
        useCase.addFavorites(email, favoritePokemons);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @DeleteMapping("/favorites")
    public ResponseEntity<String> deleteFavorite(
            @RequestParam String email,
            @RequestBody AddFavoritePokemonDto pokemonsToRemove
    ) {
        useCase.delete(email, pokemonsToRemove.getFavoritePokemonsName());
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/favorites/details")
    public ResponseEntity<PokemonDetailsDto> validateUser(
            @RequestParam String email,
            @RequestParam String pokemonName
        ){
        boolean userFavorite = useCase.validateFavorite(email, pokemonName);

        if(!userFavorite){
            throw new UserNotFoundException();
        }
        PokemonDetailsDto pokemonDetails = useCase.getDetails(pokemonName);
        return ResponseEntity.ok(pokemonDetails);
    }

}
