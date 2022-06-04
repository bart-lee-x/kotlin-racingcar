package racing.core

import racing.model.Car
import racing.model.RaceInfo
import racing.model.Round

class RaceSeries(
    private val info: RaceInfo,
    private val director: RaceDirector = RaceDirector()
) {
    private val initValue = 1 // 출발 선상있을 때 한칸으로 보일지 안보일지 모름.
    private val carChar = '-'
    fun start(): List<Round> {
        return (0 until info.rounds).map { round ->
            val roundResult = info.carNames.map { carName ->
                director.judgingMove(carName)
            }
            Round(roundNumber = round, raceResult = roundResult)
        }
    }

    // 우승자 계산
    fun winner(raceRounds: List<Round>) {

        val roundResult: List<Map<String, Pair<String, Int>>> = raceRounds
            .map { round: Round ->
                round.raceResult.map {
                    val point = if (it.advanced) 1 else 0
                    it.name to point
                }.associateBy { it.first }
            }


        val accumulatedRaceResult: List<Map<String, Int>> = listOf()

        roundResult.forEach {
            it.entries.map {  round ->
                val accPoint: Int = (accumulatedRaceResult[round.key] ?: 0) + round.value.second
                accumulatedRaceResult[round.key] = accPoint
            }
        }

        println(accumulatedRaceResult)

//        roundResult.associateBy { it ->
//            val x: Map<String, Map.Entry<String, Pair<String, Int>>> = it.entries.associateBy { it.key }
//            x
//        }


//        val r2: List<Pair<Car, Int>> = roundResult.reduce { result, pairs ->
//
//            val points: Int = pairs.sumOf {
//                it.second
//            }
//
//            result
//        }

//        accumulatedRaceResult_b.map { roundPoint: List<Int> ->
//            roundPoint.map {
//                (0 until it).map { print(carChar) }
//                println()
//            }
//            println()
//        }
    }
}