package com.github.hugovallada.pocjsonb.infra.db.model

import com.github.hugovallada.pocjsonb.infra.config.EvolutionsJsonConverter
import com.github.hugovallada.pocjsonb.infra.config.PowerJsonConverter
import com.github.hugovallada.pocjsonb.infra.config.TrainerJsonConverter
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
    @Convert(converter = PowerJsonConverter::class)
    val powers: List<Power>,
    @Column(columnDefinition = "jsonb")
    @Convert(converter = EvolutionsJsonConverter::class)
    val evolutions: List<Evolution>,
    @Column(columnDefinition = "jsonb")
    @Convert(converter = TrainerJsonConverter::class)
    val trainer: Trainer
)