package racing.model

data class RaceInfo(
    val carNames: List<String>,
    val rounds: Int
) {
    constructor(carNameString: String, rounds: Int) : this(
        carNameString
            .trim()
            .split(',')
            .filterNot { it.isEmpty() }
            .map { it.trim() }
        , rounds
    )

    init {
        require(carNames.none { it.length > NAME_LENGTH_LIMIT }) {
            throw IllegalArgumentException(NAME_LIMIT_OVER_MESSAGE)
        }
    }

    companion object {
        private const val NAME_LIMIT_OVER_MESSAGE = "5글자 초과"
        private const val NAME_LENGTH_LIMIT = 5
    }
}
