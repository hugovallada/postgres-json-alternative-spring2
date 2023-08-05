package com.github.hugovallada.pocjsonb.infra.extensions

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

inline fun <reified T> ObjectMapper.convert(json: String): T = readValue(json)