//Null-safety and Functional Patterns
var notNullable = "null"
var nullable: String? = ""

fun foo(s: String): Int{
    return s.length
}

fun bar(s: String?): Int {
    return s?.length ?: 0
}

val nameList: List<String?> = listOf("dominik", "SaScha", "kai", "larA", null)
val sanitizedList = nameList.map { name ->
    name?.let {
        capitalizeFirstChar(name)
    }
}

val crazyNameList: List<String?> = listOf("dominik", "SascHa", "kai", "laurA", null, "doMinik", "saschA", "saSCHA", null, "Laura", "Dominik", "kai", "Sascha")

val sortedDistinctNameList: List<String> = crazyNameList
    .filterNotNull()
    .map(::capitalizeFirstChar)
    .distinct()
    .sorted()

val frequencyNameList:List<Pair<String, Int>> = crazyNameList
    .filterNotNull()
    .map(::capitalizeFirstChar)
    .groupBy { it }
    .map{ Pair(it.key, it.value.size)}
    .sortedByDescending { (_, size) -> size }
    .toList()

val integerList: List<Int?> = listOf(1,2,3,4,5,6,7,8,9, null)
val summedList = integerList.fold(0) {acc, i -> acc + (i ?: 0)*2}
val otherSum = integerList.sumOf { (it?:0) } * 2

//map null safety
fun printBooksFromAuthor(author: String) {
    println(
        authorMap[author]?.joinToString(", ")
    )
}

fun fibonacci(n: Int): List<Int> {
    return (0 until n).fold(listOf(0,1)) { acc, e ->
        acc + acc.takeLast(2).sum()
    }
}

