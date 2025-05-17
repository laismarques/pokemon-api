package com.lais.pokemon_api.application.usecases;

import com.lais.pokemon_api.application.dto.PokemonSummaryDto;
import org.springframework.stereotype.Component;


@Component
public interface PokemonUseCase {


    PokemonSummaryDto listAll(String orderBy, Integer limit, Integer offset);
}
