package com.kacek.core.network.model.response

import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KType

/**
 * Response type information. Mirror class of ktor's [TypeInfo][io.ktor.util.reflect.TypeInfo].
 * @property type: source KClass<*>
 * @property reifiedType: type with substituted generics
 * @property kotlinType: kotlin reified type with all generic type parameters.
 */
data class ResponseTypeInfo(
    val type: KClass<*>,
    val reifiedType: Type,
    val kotlinType: KType? = null,
)
