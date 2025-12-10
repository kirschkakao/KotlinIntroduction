//Functions

//Free functions
fun greet(name: String) {
    println("Hallo $name")
}

fun capitalizeFirstChar(s: String): String {
    return s.lowercase().replaceFirstChar { it.uppercase() }
}

fun smartGreet(name: String) {
    println("Hallo ${capitalizeFirstChar(name)}")
}

fun freeGreet(name: String, manipulationFun: (String) -> String) {
    println("Hallo ${manipulationFun(name)}")
}

//Extension Function
fun GermanState.next(): GermanState {
    val values = enumValues<GermanState>()//GermanState.entries
    return values[(ordinal + 1) % values.size]
}

inline fun <reified T: Enum<T>> T.next(): T {
    val values = enumValues<T>()
    return values[(ordinal + 1) % values.size]
}

enum class Himmelsrichtungen {
    NORDEN, OSTEN, SUEDEN, WESTEN
}

/*fun List<Int>.printTypeInfo() {
    println("This is a list with elements of type ${Int::class}")
}*/

inline fun <reified T: Any> List<T>.printTypeInfo() {
    println("This is a list with elements of type ${T::class}")
}

fun <T : Number> List<T>.newSum(): Double {
    var output = 0.0
    for (item in this) {
        output += when (item) {
            is Double -> item
            else -> item.toDouble()
        }
    }
    return output
}


