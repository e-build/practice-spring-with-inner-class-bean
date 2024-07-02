package me.contribute.springdatajpakotlininnerclass

import jakarta.persistence.AttributeConverter

data class FooProps(
    val names: List<String>,
) {

    class Converter(
        private val fooComponent: FooComponent
    ) : AttributeConverter<FooProps, String> {

        override fun convertToDatabaseColumn(attribute: FooProps): String {
            fooComponent.foo()
            return attribute.names.joinToString("|")
        }

        override fun convertToEntityAttribute(dbData: String): FooProps {
            return FooProps(dbData.split("|"))
        }
    }
}