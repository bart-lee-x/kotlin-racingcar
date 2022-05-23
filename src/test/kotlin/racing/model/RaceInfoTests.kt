package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceInfoTests {
    @Test
    fun `쉼표로 들어온 이름을 분리할 수 있다`() {
        val round = 5
        val names = "hello,hi,die"
        val info = RaceInfo(names, round)

        assertThat(info.carNames.size).isEqualTo(3)
    }

    @Test
    fun `차 이름은 5글자 초과할 수 없다`() {
        val round = 5
        val names = "hellohi,die"

        assertThrows<IllegalArgumentException>() {
            RaceInfo(names, round)
        }
    }

    @Test
    fun `쉼표로 끝나도 잘 처리한다`() {
        val round = 5
        val names = "hello,hi,die,"

        val info = RaceInfo(names, round)
        assertThat(info.carNames.size).isEqualTo(3)
    }

    @Test
    fun `빈칸이 들어가도 잘 처리한다`() {
        val round = 5
        val names = "hello, hi, die,"

        val info = RaceInfo(names, round)
        assertThat(info.carNames.size).isEqualTo(3)
    }
}