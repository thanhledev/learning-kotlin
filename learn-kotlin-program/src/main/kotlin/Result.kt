import java.lang.Exception

sealed class Result(val message: String) {
    fun showMessage() {
        println("Result: $message")
    }
    class Success(message: String): Result(message)
    sealed class Error(message: String): Result(message) {
        class RecoverableError(exception: Exception, message: String): Error(message)
        class NonRecoverableError(exception: Exception, message: String): Error(message)
    }
    class Progress(message: String): Result(message)
}