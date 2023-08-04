package com.github.hugovallada.pocjsonb.infra.service

import com.github.hugovallada.pocjsonb.infra.db.model.Pokemon
import com.github.hugovallada.pocjsonb.infra.db.repository.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CadastrarPokemon(@Autowired private val repository: PokemonRepository) {
    fun execute(pokemon: Pokemon) {
        repository.save(pokemon)
    }
}