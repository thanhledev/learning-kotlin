class Car(name: String, var model: String, var color: String, var doors: Int) {
    lateinit var name: String

    init {
        if (name.lowercase().startsWith("a")) {
            this.name = name
        } else {
            this.name = "User"
            println("The user does not start with the 'a' or 'A' letter.")
        }
    }

    fun move() {
        println("The car $name is moving now...")
    }

    fun brake() {
        println("The car $name has been stopped...")
    }
}