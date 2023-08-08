package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Power
import com.github.hugovallada.pocjsonb.infra.extensions.convert
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class PowerJsonConverter(private val om: ObjectMapper) : AttributeConverter<List<Power>, String> {
    override fun convertToDatabaseColumn(attribute: List<Power>): String {
        return om.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<Power> {
        return om.convert(dbData)
    }
}