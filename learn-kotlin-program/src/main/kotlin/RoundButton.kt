class RoundButton(text: String, orientation: String, val corners: Int): Button(text, orientation) {
    override fun draw() {
        println("Drawing the round button with $corners")
    }
}