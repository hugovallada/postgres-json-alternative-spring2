package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Powers
import com.github.hugovallada.pocjsonb.infra.extensions.convert
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class PowerJsonConverter(private val om: ObjectMapper) : AttributeConverter<Powers, String> {
    override fun convertToDatabaseColumn(attribute: Powers): String {
        return om.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): Powers {
        return om.convert(dbData)
    }
}