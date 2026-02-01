// ===== Chapter 5: Functional Patterns =====

// === map ===
val nameList: List<String?> = listOf("dominik", "SaScha", "kai", "larA", null)
val sanitizedList = nameList.map { name ->
    name?.let {
        capitalizeFirstChar(name)
    }
}

// === filter & filterNotNull ===
val crazyNameList: List<String?> = listOf(
    "dominik", "SascHa", "kai", "laurA", null,
    "doMinik", "saschA", "saSCHA", null, "Laura", "Dominik", "kai", "Sascha"
)

val cleanList = crazyNameList.filterNotNull()

// === Chaining Operations ===
val sortedDistinctNameList: List<String> = crazyNameList
    .filterNotNull()               // Removes nulls
    .map(::capitalizeFirstChar)    // Normalizes names
    .distinct()                     // Removes duplicates
    .sorted()                       // Sorts alphabetically

// === groupBy ===
val frequencyNameList: List<Pair<String, Int>> = crazyNameList
    .filterNotNull()
    .map(::capitalizeFirstChar)
    .groupBy { it }                           // Groups by name
    .map { Pair(it.key, it.value.size) }     // Counts occurrences
    .sortedByDescending { (_, size) -> size } // Sorts by frequency
    .toList()

// === fold ===
val integerList: List<Int?> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, null)

val summedList = integerList.fold(0) { acc, i -> acc + (i ?: 0) * 2 }

val stringResult = integerList.fold(StringBuilder("Numbers: ")) { acc, i ->
    if (i != null) acc.append("$i ") else acc.append("null ")
    acc
}.toString()

// === sumOf ===
val otherSum = integerList.sumOf { (it ?: 0) } * 2


// === Advanced Example: Fibonacci ===
fun fibonacci(n: Int): List<Int> {
    return (0 until n).fold(listOf(0, 1)) { acc, _ ->
        acc + acc.takeLast(2).sum()
    }
}
