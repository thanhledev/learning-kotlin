class Car(var name: String, var model: String, var color: String, var doors: Int) {
    fun move() {
        println("The car $name is moving now...")
    }

    fun brake() {
        println("The car $name has been stopped...")
    }
}