package com.lais.pokemon_api.adapters.web;


import com.lais.pokemon_api.application.dto.UserFavoritePokemonDto;
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

    @GetMapping
    public ResponseEntity<String> getseila(
            @RequestBody User user
    ){

        return ResponseEntity.ok("teste");
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

}
