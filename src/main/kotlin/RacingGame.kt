object RacingGame {
    fun play(cars: List<Car>, movingStrategy: MovingStrategy) {
        cars.forEach { car ->
            if (movingStrategy.isMovable()) {
                car.move()
            } else {
                car.stop()
            }
        }
    }
}
