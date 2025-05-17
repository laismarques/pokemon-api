package com.lais.pokemon_api.domain.gatway;

import com.lais.pokemon_api.adapters.persistence.entity.UserEntity;
import com.lais.pokemon_api.application.dto.UserFavoritePokemonDto;
import com.lais.pokemon_api.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ReposotoryGatway {

    void save(User user);
    List<String> getFavorites(String email);
}
