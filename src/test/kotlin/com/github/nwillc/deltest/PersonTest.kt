package com.github.nwillc.deltest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    internal fun `should be able to treat as info`() {
        val person = PersonData("Wile", "Coyote").toPerson()

        assertThat(person.fName).isEqualTo("Wile")
        assertThat(person.mName).isEqualTo("")
    }
}
