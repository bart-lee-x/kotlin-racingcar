package racing.ui

import racing.model.RaceInfo

object InputView {
    private const val CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"
    private const val RACE_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun getRaceInfo(): RaceInfo {
        val racerNames = readString(CAR_NAME_MESSAGE)
        val raceRound = readNumber(RACE_ROUND_MESSAGE)

        return RaceInfo(racerNames, raceRound)
    }

    private fun readNumber(askMessage: String) = readString(askMessage).toInt()

    private fun readString(askMessage: String): String {
        println(askMessage)
        return readLine()!!
    }
}
