import java.util.*

// ===== Chapter 2: Collections =====

// === Pair and Triple ===
val coordinate: Pair<Int, Int> = Pair(0, 0)
val gps = 0.1 to -0.5  // Shorter syntax with 'to'
val andHeight: Triple<Int, Int, Int> = Triple(0, 0, 0)

// Destructuring
// val (x, y) = coordinate

// === List ===
val germanStates: List<String> = listOf("Hessen", "Bayern", "Sachsen", "Lalaland")
// val oneMore = germanStates + "Niedersachen"

// Mutable List
val mutableGermanStates: MutableList<String> = mutableListOf()
// mutableGermanStates.add("Hessen")
// mutableGermanStates.add(0, "Bayern")
// mutableGermanStates[1] = "Sachsen"

// Generic Types
val anyList: MutableList<Any> = mutableListOf(1, "")
// anyList.add(true)

// Time-Complexity of some operations:
// Add element to the end/start: O(1) (amortized)
// Add element to index: O(N)
// Check element existence: O(N)
// Add two lists: O(N)

// === Set ===
var germanStateSet: Set<String> = setOf("Hessen", "Bayern", "Sachsen", "Hessen")
// Result: {"Hessen", "Bayern", "Sachsen"} - "Hessen" appears only once

var mutableGermanStateSet: MutableSet<String> = mutableSetOf("Hessen", "Bayern", "Sachsen", "Hessen")
// mutableGermanStateSet.add("Bayern")

// Time-Complexity of some operations:
// Add element: O(1)
// Check element existence: O(1)
// Add two sets: O(N)

// Sorted Set
val sortedStateSet: SortedSet<String> = sortedSetOf("Hessen", "Bayern", "Sachsen", "Hessen")
// Time-Complexity of some operations:
// Add element: O(ln(N))
// Check element existence: O(ln(N))
// Add two sets: O(N)

// === Map ===
val authorMap: Map<String, List<String>> = mapOf(
    "J.R.R. Tolkien" to listOf("The Lord of the Rings", "The Hobbit")
)
val mutableAuthorMap: MutableMap<String, List<String>> = mutableMapOf()
// mutableAuthorMap["J.K. Rowling"] = listOf("Harry Potter")

// === Enum ===
enum class GermanState {
    BADEN_WUERTTEMBERG,
    BAYERN,
    BERLIN,
    BRANDENBURG,
    BREMEN,
    HAMBURG,
    HESSEN,
    MECKLENBURG_VORPOMMERN,
    NIEDERSACHSEN,
    NORDRHEIN_WESTFALEN,
    RHEINLAND_PFALZ,
    SAARLAND,
    SACHSEN,
    SACHSEN_ANHALT,
    SCHLESWIG_HOLSTEIN,
    THUERINGEN
}

// === Ranges ===
val oneToTen = 1..10
val evenNumbers = 2..20 step 2
val countdown = 10 downTo 1
