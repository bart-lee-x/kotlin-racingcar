package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTests {

    @Test
    fun `Car has name`() {
        val name = "abc"
        val aCar = Car(name, false)
        assertThat(aCar.name).isEqualTo(name)
    }
}