package racing.core

import racing.model.Car

class RaceDirector(
    val raceRule: RaceRule = RaceRule()
) {
    fun judgingMove(carName: String): Car {
        val judged = raceRule.range.random() > raceRule.threshold
        return Car(carName, judged)
    }

    data class RaceRule(
        val range: IntRange = (0..9),
        val threshold: Int = 4
    )
}

