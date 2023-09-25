class Plane(name: String, color: String, val engines: Int, val doors: Int): Vehicle(name, color) {
    override fun move() {
        flying()
    }

    private fun flying() {
        println("$name is flying in the air now.")
    }
}