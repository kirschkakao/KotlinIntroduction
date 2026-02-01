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

// === Combining Null-Safety with Collections ===
fun printBooksFromAuthor(author: String) {
    val books = authorMap[author]?.joinToString(", ") ?: "No books found"
    println(books)
}

// === Scope Functions ===

// let - for null-safety
fun letExample(name: String?) {
    name?.let {
        println("Name is: $it")
        println("Length is: ${it.length}")
        println("Uppercase: ${it.uppercase()}")
    }
}

// run - execute block and return result
fun runExample() {
    val result = "Kotlin".run {
        println("Length: $length")
        uppercase()
    }
}

// also - side effects
fun alsoExample() {
    val name = "Kotlin"
        .also { println("Created: $it") }
        .also { println("Length: ${it.length}") }
    println("Final: $name")
}

// apply - configure object
data class Book(var title: String = "", var author: String = "")

fun applyExample() {
    val book = Book().apply {
        title = "1984"
        author = "George Orwell"
    }
    println(book)
}

// with - execute block on object
fun withExample() {
    val text = "Kotlin"

    with(text) {
        println("Text: $this")
        println("Length: $length")
        println("Uppercase: ${uppercase()}")
    }
}
