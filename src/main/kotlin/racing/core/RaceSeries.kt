package racing.core

import racing.model.Car
import racing.model.RaceInfo
import racing.model.Round

class RaceSeries(
    private val info: RaceInfo,
    private val director: RaceDirector = RaceDirector()
) {
    fun start(): List<Round> {
        return (0 until info.rounds).map { round ->
            val roundResult = info.carNames.map { carName ->
                director.judgingMove(carName)
            }
            Round(roundNumber = round, raceResult = roundResult)
        }
    }

    fun raceRule(): RaceDirector.RaceRule = director.raceRule

}