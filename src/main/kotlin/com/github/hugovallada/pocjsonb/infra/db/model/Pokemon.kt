package com.github.hugovallada.pocjsonb.infra.db.model

import com.github.hugovallada.pocjsonb.infra.config.JsonbToStringConverter
import javax.persistence.*

@Entity
@Table(name = "pokemons")
data class Pokemon(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null,
    val name: String,
    val type: String,
    @Column(columnDefinition = "jsonb")
    val powers: String,
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbToStringConverter::class)
    val evolutions: String,
    @Column(columnDefinition = "jsonb")
    val trainer: String
)