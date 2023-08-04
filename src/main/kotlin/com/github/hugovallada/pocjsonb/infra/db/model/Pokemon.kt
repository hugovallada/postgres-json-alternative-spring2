package com.github.hugovallada.pocjsonb.infra.db.model

import javax.persistence.*

@Entity
@Table(name = "pokemons")
data class Pokemon(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null,
    val name: String,
    val type: String,
    @Column(columnDefinition = "text")
    val powers: String,
    @Column(columnDefinition = "text")
    val evolutions: String,
    @Column(columnDefinition = "text")
    val trainer: String
)