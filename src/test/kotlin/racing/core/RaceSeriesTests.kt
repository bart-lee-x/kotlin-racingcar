package racing.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.RaceInfo

class RaceSeriesTests {

    @Test
    fun `raceSeries result should be return correct race round size and car count`() {
        val raceRounds = 5
        val racerNames = "abc, efg"
        val raceInfo = RaceInfo(racerNames, raceRounds)

        val raceSeries = RaceSeries(raceInfo)
        val result = raceSeries.start()

        assertThat(result.size).isEqualTo(raceRounds)
        assertThat(result.first().raceResult.size).isEqualTo(racerNames.split(',').size)
    }

    @Test
    fun `raceSeries 는 winner()로 결과 합산 가능`() {
        val raceRounds = 5
        val racerNames = "abc, efg"
        val raceInfo = RaceInfo(racerNames, raceRounds)

        val raceSeries = RaceSeries(raceInfo)
        val result = raceSeries.start()
        val r2 = raceSeries.winner(result)

        assertThat(result.size).isEqualTo(raceRounds)
        assertThat(result.first().raceResult.size).isEqualTo(racerNames.split(',').size)
    }

}