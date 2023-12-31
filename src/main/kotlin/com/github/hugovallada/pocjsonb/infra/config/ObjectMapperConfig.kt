package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConfig {

    @Bean
    fun initObjectMapper(): ObjectMapper = ObjectMapper()
}