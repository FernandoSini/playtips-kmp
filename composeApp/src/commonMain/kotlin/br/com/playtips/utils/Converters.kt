package br.com.playtips.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters{
    fun listToJson(value:List<String>?) = Json.encodeToString(value)

    fun jsonToList(value:String) = Json.decodeFromString<List<String>>(value)

    fun setToJson(value: Set<String>?) = Json.encodeToString(value)

    fun jsonToSet(value:String) = Json.decodeFromString<Set<String>>(value)
}