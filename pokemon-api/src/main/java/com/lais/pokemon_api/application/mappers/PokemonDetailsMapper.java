package com.lais.pokemon_api.application.mappers;


import com.lais.pokemon_api.adapters.pokeapi.dto.PokeDetailDto;
import com.lais.pokemon_api.application.dto.PokemonDetailsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class PokemonDetailsMapper {
    public static PokemonDetailsDto toDetailsDto(PokeDetailDto apiDto) {
        PokemonDetailsDto dto = new PokemonDetailsDto();

        dto.setName(apiDto.getName());
        dto.setHeight(apiDto.getHeight());
        dto.setWeight(apiDto.getWeight());

        // Types: extraindo apenas os nomes
        List<String> types = apiDto.getTypes().stream()
                .map(slot -> slot.getType().getName())
                .collect(Collectors.toList());
        dto.setTypes(types);

        // Abilities: extraindo apenas os nomes
        List<String> abilities = apiDto.getAbilities().stream()
                .map(slot -> slot.getAbility().getName())
                .collect(Collectors.toList());
        dto.setAbilities(abilities);

        // Stats: mapeando nome do stat com seu valor base
        Map<String, Integer> stats = apiDto.getStats().stream()
                .collect(Collectors.toMap(
                        stat -> stat.getStat().getName(),
                        PokeDetailDto.StatSlot::getBase_stat
                ));
        dto.setStats(stats);

        // Sprite (imagem frontal)
        dto.setSprite(apiDto.getSprites().getFront_default());

        return dto;
    }
}
