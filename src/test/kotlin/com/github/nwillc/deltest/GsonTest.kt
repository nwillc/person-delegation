package com.github.nwillc.deltest

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Test

class GsonTest {
    val gson: Gson = GsonBuilder().create()

    @Test
    fun `should be able to serialize and deserialize a person`() {
        val person = PersonData("Wile", "Coyote").toPerson()

        val json = gson.toJson(person)
        println(json)

        val fromJson = gson.fromJson(json, Person::class.java)
        println(fromJson)
    }
}
