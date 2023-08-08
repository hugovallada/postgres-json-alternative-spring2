package com.github.hugovallada.pocjsonb.infra.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class GetPokemon(private val repository: PokemonRepository, private val om: ObjectMapper) {
    fun execute() {
        repository.findAll().forEach { pokemon ->
            println("Power Kotlin: ${pokemon.powers}")
            println("Evolution Kotlin: ${pokemon.evolutions}")
            println("Trainer Kotlin: ${pokemon.trainer}")

            println("---------------")
            println("Pokemon: $pokemon")
        }
    }
}