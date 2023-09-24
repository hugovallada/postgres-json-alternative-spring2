package com.github.hugovallada.pocjsonb.infra.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Evolution
import com.github.hugovallada.pocjsonb.infra.db.model.Pokemon
import com.github.hugovallada.pocjsonb.infra.db.model.Power
import com.github.hugovallada.pocjsonb.infra.db.model.Trainer
import com.github.hugovallada.pocjsonb.infra.service.CadastrarPokemon
import com.github.hugovallada.pocjsonb.infra.service.GetPokemon
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemon")
class PokemonController(
    private val cadastrarPokemon: CadastrarPokemon,
    private val getPokemon: GetPokemon,
    private val om: ObjectMapper
) {

    @PostMapping
    fun salvar() {
        val powers = listOf(
            Power("flame breath", level = 1, element = "fire"),
            Power("flame punch", level = 2, element = "fire")
        )

        val evolutions = listOf(
            Evolution(
                "Charmeleon", 1, listOf(
                    Power("flame breath charmeleon", level = 1, element = "fire"),
                    Power("flame punch charmeleon", level = 2, element = "fire")
                )
            ),
            Evolution(
                "Charizard", 2, listOf(
                    Power("flame breath charizard", level = 1, element = "fire"),
                    Power("flame punch charizard", level = 2, element = "fire")
                )
            )
        )

        val trainer = Trainer(
            "Hugo", 27
        )

        val p = Pokemon(
            name = "Charmander",
            type = "Fire",
            powers = powers,
            evolutions = evolutions,
            trainer = trainer
        )
        cadastrarPokemon.execute(p)
    }

    @GetMapping
    fun listar() {
        getPokemon.execute()
    }
}