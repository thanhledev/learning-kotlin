import kotlinx.coroutines.*
import java.time.Instant
import java.util.*
import kotlin.concurrent.thread;
import kotlin.coroutines.EmptyCoroutineContext

// READ MORE: https://reflectoring.io/understanding-kotlin-coroutines-tutorial/
// using fun main(...) = runBlocking { ... } to block the currently executing main thread,
// until all the code in the coroutine is completed.
fun main(args: Array<String>) = runBlocking {
    // old threading approach
    /*
    println("My program runs...: ${Thread.currentThread().name}")
    thread {
        longRunningTaskThreading()
    }
    println("My program ends...: ${Thread.currentThread().name}")
    */

    // coroutine approach
    /*
    println("My program runs...: ${Thread.currentThread().name}")

    // starting a coroutine
    launch {
        longRunningTaskCoroutine() // invoking long running task
    }
    println("My program ends...: ${Thread.currentThread().name}")
    */

    // Introducing Suspending Functions
    /*
    println("${Instant.now()}: My program runs...: ${Thread.currentThread().name}")

    val productId = findProduct()
    launch(Dispatchers.Unconfined) {
        fetchPrice(productId)
    }
    updateProduct()

    println("${Instant.now()}: My program ends...: ${Thread.currentThread().name}")
    */

    // The runBlocking coroutine builder starts a coroutine by blocking the currently executing thread,
    // till all the code in the coroutine is completed.
    // For example: fun main() = runBlocking { ... } in the previous examples will block the main thread
    // until the code inside the launch {} finishes.

    // Fire and forget with launch {}
    /*
    println("${Instant.now()}: My program runs...: ${Thread.currentThread().name}")

    val longJob: Job = launch(EmptyCoroutineContext, CoroutineStart.DEFAULT) {
        longRunningTask()
    }
    longJob.join()

    println("${Instant.now()}: My program ends...: ${Thread.currentThread().name}")
    */

    // Return Result of Suspending Function to the Launching Thread with async
    /*
    println("${Instant.now()}: My program runs...: ${Thread.currentThread().name}")

    val taskDeferred = async {
        generateUniqueID()
    }
    val taskResult = taskDeferred.await()

    println("${Instant.now()}: My program ends...: ${Thread.currentThread().name} => get uniqueID = ${taskResult}")
    */

}

// old threading approach
/*
fun longRunningTaskThreading() {
    println("executing longRunningTask on... ${Thread.currentThread().name}")
    Thread.sleep(1000)
    println("longRunningTask ends on thread ...: ${Thread.currentThread().name}")
}*/

// Coroutine approach

suspend fun longRunningTaskCoroutine() {
    println("executing longRunningTask on... ${Thread.currentThread().name}")
    delay(1000)
    println("longRunningTask ends on thread ...: ${Thread.currentThread().name}")
}

suspend fun generateUniqueID(): String {
    println("executing generateUniqueID on...: ${Thread.currentThread().name}")
    delay(2000)
    println("generateUniqueID ends on thread ...: ${Thread.currentThread().name}")

    return UUID.randomUUID().toString()
}

suspend fun fetchPrice(productId: String) : Double{
    println("${Instant.now()}: fetchPrice starts on...: ${Thread.currentThread().name} ")
    delay(2000) // simulate the slow function by adding a delay
    println("${Instant.now()}: fetchPrice ends on...: ${Thread.currentThread().name} ")
    return 234.5
}

fun findProduct() : String{
    println("${Instant.now()}: findProduct on...: ${Thread.currentThread().name}")
    return "P12333"
}

fun updateProduct() : String{
    println("${Instant.now()}: updateProduct on...: ${Thread.currentThread().name}")
    return "Product updated"
}
