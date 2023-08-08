package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.extensions.convert
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class JsonbToStringConverter(private val om: ObjectMapper) : AttributeConverter<String, String> {

    override fun convertToDatabaseColumn(attribute: String): String {
        return om.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): String {
        return om.convert(dbData)
    }
}