import java.util.*

//Collections
//Pair
val coordinate: Pair<Int, Int> = Pair(0, 0)

//List
//List<T> -> generic type
val germanStates: List<String> = listOf("Hessen", "Bayern", "Sachsen", "Lalaland")
val mutableGermanStates: MutableList<String> = mutableListOf()
val anyList: MutableList<Any> = mutableListOf(1, "")
//Time-Complexity of some operations:
// Add element to the end/start: O(1) (amortized)
// Add element to index: O(N)
// Check element existence: O(N)
// add two lists: O(N)

//Set
var germanStateSet: Set<String> = setOf("Hessen", "Bayern", "Sachsen", "Hessen")
var mutableGermanStateSet: MutableSet<String> = mutableSetOf("Hessen", "Bayern", "Sachsen", "Hessen")
//Time-Complexity of some operations:
// Add element: O(1)
// Add element to index: impossible
// Check element existence: O(1)
// add two sets: O(N)

//Sorted Set
val sortedStateSet: SortedSet<String> = sortedSetOf("Hessen", "Bayern", "Sachsen", "Hessen")
//Time-Complexity of some operations:
// Add element: O(ln(N))
// Add element to index: impossible
// Check element existence: O(ln(N))
// add two sets: O(N)

//Map
val authorMap: Map<String, List<String>> = mapOf("J.R.R. Tolkien" to listOf("Herr der Ringe - Die Gefaehrten", "Der Hobbit"))
val mutableAuthorMap: MutableMap<String, List<String>> = mutableMapOf()

//Enum
enum class GermanState {
    HESSEN, BAYERN
}

val enumStates: List<GermanState> = listOf(GermanState.BAYERN)
