package com.github.hugovallada.pocjsonb.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hugovallada.pocjsonb.infra.db.model.Trainer
import com.github.hugovallada.pocjsonb.infra.extensions.convert
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class TrainerJsonConverter(private val om: ObjectMapper) : AttributeConverter<Trainer, String> {
    override fun convertToDatabaseColumn(attribute: Trainer): String {
        return om.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): Trainer {
        return om.convert(dbData)
    }
}