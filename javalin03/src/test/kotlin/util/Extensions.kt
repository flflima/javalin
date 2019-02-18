package util

// Extensions.kt

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

inline fun <reified T : Any> String.deserialize(): T =
    jacksonObjectMapper().readValue(this)