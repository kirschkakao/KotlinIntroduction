import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Coroutines
const val dFine = "d-fine"
const val slogan = "We define Consulting"

fun normalThread() {
    println(dFine)
    Thread.sleep(1000)
    println(slogan)
}

fun coroutine() = runBlocking {
    defineConsulting()
    val job = launch {
        delay(2000)
        println("Hallo")

    }.join()
    println(dFine)
}

suspend fun defineConsulting() {
    delay(1000)
    println(slogan)
}

fun leightweightExample() = runBlocking {
    repeat(50000) {
        launch{
            delay(5000)
            print(".")
        }
    }
}
