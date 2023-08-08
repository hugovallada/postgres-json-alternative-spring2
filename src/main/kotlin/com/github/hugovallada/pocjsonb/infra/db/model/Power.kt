package com.github.hugovallada.pocjsonb.infra.db.model


typealias Powers = List<Power>
typealias Evolutions = List<Evolution>

@NoArg
data class Power(
    val name: String,
    val level: Int,
    val element: String
)

@NoArg
data class Evolution(
    val name: String,
    val level: Int,
    val powers: Powers
)

@NoArg
data class Trainer(
    val name: String,
    val age: Int
)

annotation class NoArg