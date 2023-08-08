package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Evolutions
import com.github.hugovallada.pocjsonb.infra.extensions.convert
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class EvolutionsJsonConverter(private val om: ObjectMapper) : AttributeConverter<Evolutions, String> {

    override fun convertToDatabaseColumn(attribute: Evolutions): String {
        return om.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): Evolutions {
        return om.convert(dbData)
    }
}