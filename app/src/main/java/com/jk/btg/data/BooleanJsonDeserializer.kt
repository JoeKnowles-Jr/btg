package com.jk.btg.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.util.Locale


internal class BooleanJsonDeserializer : JsonDeserializer<Boolean?> {
    private val truestrings: Set<String> = HashSet(mutableListOf("true", "1", "yes"))

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Boolean {
        println(json)
        val jsonPrimitive = json.asJsonPrimitive
        if (jsonPrimitive.isBoolean) {
            return jsonPrimitive.asBoolean
        } else if (jsonPrimitive.isNumber) {
            return jsonPrimitive.asNumber.toInt() == 1
        } else if (jsonPrimitive.isString) {
            return truestrings.contains(jsonPrimitive.asString.lowercase(Locale.getDefault()))
        }

        return false
    }
}