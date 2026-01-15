import kotlinx.coroutines.*

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
    launch {
        delay(1000)
        println("Hallo")
    }
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

suspend fun getSlogan(): String {
    delay(1000)
    return slogan
}

suspend fun getName(): String {
    delay(1000)
    return dFine
}

fun notParallelExample() = runBlocking {
    println("${getName()}: ${getSlogan()}")
}

fun awaitExample() = runBlocking {
    val nameDeferred = async {
        getName()
    }
    val sloganDeferred = async {
        getSlogan()
    }

    println("${nameDeferred.await()}: ${sloganDeferred.await()}")
}

fun awaitAllExample() = runBlocking {
    val (slogan, name) = awaitAll(
        async { getSlogan() },
        async { getName() }
    )
    println("$name: $slogan")
}


