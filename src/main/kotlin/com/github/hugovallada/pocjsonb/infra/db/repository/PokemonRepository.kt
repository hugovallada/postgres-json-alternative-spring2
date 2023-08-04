package com.github.hugovallada.pocjsonb.infra.db.repository

import com.github.hugovallada.pocjsonb.infra.db.model.Pokemon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<Pokemon, Long>