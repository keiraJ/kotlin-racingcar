package racing

import racing.Constants.CAR_INPUT_MESSAGE
import racing.Constants.TRIES_INPUT_MESSAGE

object CarRacingInputHandler {
    fun input(): InputParams {
        displayCarMessage()
        val carNames = readln()
        val cars = carNames.split(",")

        displayTriesMessage()
        val numberOfTries = readln()

        return InputParams(cars.size.toString(), numberOfTries, cars)
    }

    private fun displayCarMessage() {
        println(CAR_INPUT_MESSAGE)
    }

    private fun displayTriesMessage() {
        println(TRIES_INPUT_MESSAGE)
    }

    fun validate(numberOfCar: String, numberOfTries: String, cars: List<String>) {
        require(numberOfCar.isNotEmpty() && numberOfTries.isNotEmpty()) { Constants.INVALID_ARGUMENT_MESSAGE }
        require(numberOfCar.toIntOrNull() != null && numberOfTries.toIntOrNull() != null) { Constants.INVALID_ARGUMENT_MESSAGE }
        require(!validCarsName(cars)) { Constants.INVALID_CAR_NAME_MESSAGE }
    }

    private fun validCarsName(cars: List<String>): Boolean {
        return cars.any { it.length >= CAR_NAME_LIMIT }
    }

    fun getCars(inputParams: InputParams): List<Car> {
        return inputParams.carNames.map(::Car)
    }

    private const val CAR_NAME_LIMIT = 5
}
