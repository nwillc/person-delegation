package com.github.nwillc.deltest

import org.junit.jupiter.api.Test

class PersonDataTest {
    @Test
    fun `should have name`() {
        PersonData("Wile", "Coyote")
    }
}
