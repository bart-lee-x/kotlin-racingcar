package racing

import racing.core.RaceSeries
import racing.model.RaceInfo
import racing.ui.InputView
import racing.ui.ResultView

fun main() {

    val raceInfo: RaceInfo
    try {
        raceInfo = InputView.getRaceInfo()
    } catch (e: NumberFormatException) { // TODO: 이제 이름을 받으니 문자 관련이나 파싱 에러가 올듯.
        throw IllegalArgumentException("wrong input, null")
    } catch (e: NullPointerException) {
        throw IllegalArgumentException("wrong input, null")
    }

    val raceSeries = RaceSeries(raceInfo)
    val raceResult = raceSeries.start()

    ResultView.show(raceResult, raceInfo.carNames.size)

}


