package com.github.hugovallada.pocjsonb.infra.db.model


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
    val powers: List<Power>
)

@NoArg
data class Trainer(
    val name: String,
    val age: Int
)

annotation class NoArg