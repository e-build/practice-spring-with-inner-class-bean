package me.contribute.springdatajpakotlininnerclass

import jakarta.persistence.*

@Table(name = "foo")
@Entity
class FooEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Convert(converter = FooProps.Converter::class)
    var props: FooProps? = null,
)