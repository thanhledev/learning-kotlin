enum class Direction(var dir: String, var distance: Int) {
    NORTH("north", 10),
    SOUTH("south", 11),
    EAST("east", 12),
    WEST("west", 13);

    // functions
    fun printData() {
        println("Direction = $dir and distance=$distance")
    }
}