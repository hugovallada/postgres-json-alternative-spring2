package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Evolution
import com.github.hugovallada.pocjsonb.infra.extensions.convert
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class EvolutionsJsonConverter(private val om: ObjectMapper) : AttributeConverter<List<Evolution>, String> {

    override fun convertToDatabaseColumn(attribute: List<Evolution>): String {
        return om.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<Evolution> {
        return om.convert(dbData)
    }
}