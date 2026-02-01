// ===== Chapter 4: Null-Safety and Scope Functions =====

// === Nullable vs Non-Nullable Types ===
var notNullable: String = "null" // Cannot be null
var nullable: String? = null     // Can be null (with ?)

// === Functions with Nullable Parameters ===
fun foo(s: String): Int {
    return s.length  // s cannot be null
}

fun bar(s: String?): Int {
    return s?.length ?: 0  // Safe call and Elvis operator
}

// === Scope Functions ===

// let - for null-safety
fun letExample() {
    val name: String? = "Kotlin"
    name?.let {
        println("Name is: $it")
        println("Length is: ${it.length}")
    }
}

// apply - configure object
fun applyExample() {
    val contact = Contact("Bruce", "Wayne", "123").apply {
        // Can modify properties here if they were var
    }
}

// also - side effects
fun alsoExample() {
    val numbers = mutableListOf(1, 2, 3)
        .also { println("Before: $it") }
        .apply { add(4) }
        .also { println("After: $it") }
}

// run - execute block and return result
fun runExample() {
    val result = "Kotlin".run {
        println("Length: $length")
        uppercase()
    }
}

// with - execute block on object
fun withExample() {
    val contact = Contact("Bob", "Builder", "456")
    with(contact) {
        println("Name: $firstName")
        println("Number: $mobileNumber")
    }
}
