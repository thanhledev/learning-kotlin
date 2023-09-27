class WordProcessor(private val software: Software): Software {
    override fun getLicense(): String = software.getLicense()
}