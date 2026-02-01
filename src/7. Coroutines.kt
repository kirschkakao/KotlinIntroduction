import kotlinx.coroutines.*

// ===== Chapter 7: Coroutines =====

const val dFine = "d-fine"
const val slogan = "We define Consulting"

fun normalThread() {
    println(dFine)
    Thread.sleep(1000)  // Blocks the thread
    println(slogan)
}

// Suspend function
suspend fun defineConsulting() {
    delay(1000)  // Non-blocking delay
    println(slogan)
}

// Using runBlocking
fun coroutine() = runBlocking {
    defineConsulting()
    println(dFine)
}

// === launch ===
fun coroutine2() = runBlocking {
    launch {
        defineConsulting()
    }
    println(dFine)
}

// Lightweight coroutines example
fun lightweightExample() = runBlocking {
    repeat(50000) {
        launch {
            delay(5000)
            print(".")
        }
    }
}

// === async/await ===

suspend fun getSlogan(): String {
    delay(1000)
    return slogan
}

suspend fun getName(): String {
    delay(1000)
    return dFine
}

// Sequential execution (slow)
fun notParallelExample() = runBlocking {
    println("${getName()}: ${getSlogan()}")
    // Takes ~2 seconds
}

// Parallel execution with async/await
fun awaitExample() = runBlocking {
    val nameDeferred = async {
        getName()
    }
    val sloganDeferred = async {
        getSlogan()
    }

    println("${nameDeferred.await()}: ${sloganDeferred.await()}")
    // Takes ~1 second (parallel)
}

// Using awaitAll
fun awaitAllExample() = runBlocking {
    val (name, slogan) = awaitAll(
        async { getName() },
        async { getSlogan() }
    )
    println("$name: $slogan")
}

// === Structured Concurrency ===
suspend fun loadUser(): String {
    delay(1000)
    return "User"
}

suspend fun loadPosts(): String {
    delay(1500)
    return "Posts"
}

fun structuredConcurrency() = runBlocking {
    coroutineScope {
        val user = async { loadUser() }
        val posts = async { loadPosts() }
        println("${user.await()}: ${posts.await()}")
    }
}

// === Dispatchers ===
fun dispatcherExample() = runBlocking {
    launch(Dispatchers.Default) {
        println("Default: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("IO: ${Thread.currentThread().name}")
    }

    // Note: Dispatchers.Main is only available in Android/UI contexts
    // launch(Dispatchers.Main) {
    //     println("Main: ${Thread.currentThread().name}")
    // }
}


