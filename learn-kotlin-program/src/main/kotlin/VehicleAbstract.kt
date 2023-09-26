abstract class VehicleAbstract {
    abstract fun move()
    abstract fun stop()
}

class CarImplement(var name: String, var color: String, val engines: Int, val doors: Int)
    : VehicleAbstract() {
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}