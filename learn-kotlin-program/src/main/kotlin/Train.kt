class Train(name: String, color: String, val engines: Int, val doors: Int): Vehicle(name, color) {
    override fun stop() {
        arrive()
    }

    private fun arrive() {
        println("$name is stopped at the station now.")
    }
}