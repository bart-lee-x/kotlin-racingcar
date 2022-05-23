package racing.ui

import racing.model.Round

object ResultView {
    private const val initValue = 1 // 출발 선상있을 때 한칸으로 보일지 안보일지 모름.
    private const val carChar = '-'

    fun show(raceSeriesResult: List<Round>, racersSize: Int) {
        val raceResult = List(racersSize) { initValue }

        val accumulatedRaceResult = raceSeriesResult
            .map { round -> round.raceResult.map { if (it.advanced) 1 else 0 } }
            .runningFold(raceResult) { total, round ->
                total.mapIndexed { index, it -> it + round[index] }
            }

        val accumulatedRaceRound = raceSeriesResult
            .map { round ->
                round.raceResult.map { car -> if (car.advanced) 1 else 0 }
            }
            .runningFold(raceResult) { total, round ->
                total.mapIndexed { index, it -> it + round[index] }
            }

        println("실행 결과")
        accumulatedRaceResult.map { roundPoint: List<Int> ->
            roundPoint.map {
                (0 until it).map { print(carChar) }
                println()
            }
            println()
        }
    }
}