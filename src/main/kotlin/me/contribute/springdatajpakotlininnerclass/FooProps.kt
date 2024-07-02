package me.contribute.springdatajpakotlininnerclass

import jakarta.persistence.AttributeConverter

data class FooProps(
    val names: List<String>,
) {

    /**
     * spring-data-jpa 에서 AttributeConverter의 구현체들은 spring bean 으로 자동 등록됨.
     * outer 클래스가 빈으로 등록되어 있지않으면 inner 클래스를 인스턴스화할 수 있는 방법이 없기 때문에,
     * 애플리케이션 구동 시 오류 발생
     */
//    inner class Converter(
//        private val fooComponent: FooComponent
//    ) : AttributeConverter<FooProps, String> {
//
//        override fun convertToDatabaseColumn(attribute: FooProps): String {
//            fooComponent.foo()
//            return attribute.names.joinToString("|")
//        }
//
//        override fun convertToEntityAttribute(dbData: String): FooProps {
//            return FooProps(dbData.split("|"))
//        }
//    }

    /**
     * static 하게 load 되는 코틀린의 기본 중첩클래스.
     * outer 클래스와 무관하게 중첩클래스 만으로도 스프링빈 생성이 가능하기 때문에,
     * outer 클래스가 스프링 빈으로 등록되어 있지 않더라도 오류없이 빈등록
     */
    class Converter(
        private val fooComponent: FooComponent,
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