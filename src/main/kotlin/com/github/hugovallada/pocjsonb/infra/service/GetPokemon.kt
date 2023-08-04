package com.github.hugovallada.pocjsonb.infra.service

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Evolution
import com.github.hugovallada.pocjsonb.infra.db.model.Power
import com.github.hugovallada.pocjsonb.infra.db.model.Trainer
import com.github.hugovallada.pocjsonb.infra.db.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class GetPokemon(private val repository: PokemonRepository, private val om: ObjectMapper) {
    fun execute() {
        val pokemons = repository.findAll()
        val pokemon = pokemons[0]
        val power = om.readValue(pokemon.powers, object: TypeReference<List<Power>>(){})
        val evolution = om.readValue(pokemon.evolutions, object : TypeReference<List<Evolution>>(){})
        val trainer = om.readValue(pokemon.trainer, Trainer::class.java)

        println("Power: $power")
        println("Evolution: $evolution")
        println("Trainer: $trainer")
    }
}