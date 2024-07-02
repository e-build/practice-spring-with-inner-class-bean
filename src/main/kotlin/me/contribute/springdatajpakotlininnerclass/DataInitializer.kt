package me.contribute.springdatajpakotlininnerclass

import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DataInitializer(
    private val em: EntityManager,
) {

    @Transactional
    fun init() {
        val entity = FooEntity(
            props = FooProps(listOf("aaa", "bbb", "ccc")),
        )
        em.persist(entity)
    }

}