package com.lais.pokemon_api.adapters.pokeapi.dto;

import java.util.List;

public record PokeApiResponseDto(Integer count, String next, List<PokeSummaryDto> results) {
}
