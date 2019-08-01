package com.github.nwillc.deltest

import java.util.UUID

interface PersonInfo {
    val fName: String
    val lName: String
    val mName: String
}

data class Person(
    private val data: PersonData,
    val id: UUID
): PersonInfo by data {
    constructor(data: PersonData) : this(data, UUID.randomUUID())
}

data class PersonData(
    override val fName: String,
    override val lName: String,
    override val mName: String = ""
) : PersonInfo {
    fun toPerson(id: UUID = UUID.randomUUID()): Person = Person(this, id)
}
