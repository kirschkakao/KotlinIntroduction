import java.util.*

// ===== Chapter 2: Collections =====

// === Pair and Triple ===
val coordinate: Pair<Int, Int> = Pair(0, 0)
val gps = 0.1 to -0.5  // Shorter syntax with 'to'
val andHeight: Triple<Int, Int, Int> = Triple(0, 0, 0)

// === List ===
val germanStates: List<String> = listOf("Hessen", "Bayern", "Sachsen", "Lalaland")
val newGermanStates  = germanStates + "Niedersachen"

// Mutable List
val mutableGermanStates: MutableList<String> = mutableListOf()

// Generic Types
val anyList: MutableList<Any> = mutableListOf(1, "")


// === Set ===
var germanStateSet: Set<String> = setOf("Hessen", "Bayern", "Sachsen", "Hessen")

var mutableGermanStateSet: MutableSet<String> = mutableSetOf("Hessen", "Bayern", "Sachsen", "Hessen")


// Sorted Set
val sortedStateSet: SortedSet<String> = sortedSetOf("Hessen", "Bayern", "Sachsen", "Hessen")


// === Map ===
val authorMap: Map<String, List<String>> = mapOf(
    "J.R.R. Tolkien" to listOf("The Lord of the Rings", "The Hobbit")
)
val mutableAuthorMap: MutableMap<String, List<String>> = mutableMapOf()

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
