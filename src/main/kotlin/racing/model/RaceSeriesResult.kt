package racing.model

data class RaceSeriesResult(
    val carStanding: List<CarPoint>,
//    val winner: List<CarPoint>
) {
    data class CarPoint(
        val car: Car,
        val point: Int
    )
}