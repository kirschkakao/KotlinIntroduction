// ===== Chapter 3: Functions =====

// === Free Functions ===

// Easy functions
fun greet(name: String) {
    println("Hello $name")
}

// Functions with return value
fun capitalizeFirstChar(s: String): String {
    return s.lowercase().replaceFirstChar { it.uppercase() }
}

// Function use in another function
fun smartGreet(name: String) {
    println("Hello ${capitalizeFirstChar(name)}")
}


// === Higher-Order Functions ===
fun freeGreet(name: String, manipulationFun: (String) -> String) {
    println("Hello ${manipulationFun(name)}")
}


// === Extension Functions ===

// Simple Extension Function
fun GermanState.next(): GermanState {
    val values = enumValues<GermanState>()
    return values[(ordinal + 1) % values.size]
}

// Extension Function for String
fun String.capitalizeFirstChar2(): String {
    return this.lowercase().replaceFirstChar { it.uppercase() }
}

// Extension Function with Type Constraint
fun <T : Number> List<T>.newSum(): Double {
    var output = 0.0
    for (element in this) {
        output += element.toDouble()
    }
    return output
}

// Generic Extension Function
inline fun <reified T: Enum<T>> T.next(): T {
    val values = enumValues<T>()
    return values[(ordinal + 1) % values.size]
}

enum class CardinalDirections {
    NORTH, EAST, SOUTH, WEST
}

// Extension Function with Generic Type
inline fun <reified T: Any> List<T>.printTypeInfo() {
    println("This is a list with elements of type ${T::class}")
}




