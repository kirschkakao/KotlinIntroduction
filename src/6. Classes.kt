// ===== Chapter 6: Classes and Objects =====

// === Basic Classes ===
class Person(
    val firstName: String,
    val lastName: String
) {
    fun greet() {
        println("Hello, my name is $firstName $lastName")
    }
}

// === Open Classes ===
enum class TerrainType {
    LAND, WATER, AIR
}

open class Vehicle(
    val modelName: String,
    val terrainType: TerrainType
) {
    protected open fun buildOutputString(): String {
        return "This is a $modelName. It operates ${if(terrainType == TerrainType.AIR) "in" else "on"} " +
                capitalizeFirstChar(terrainType.toString())
    }

    fun print() {
        numOfPrintedVehicles += 1
        println(buildOutputString())
    }

    fun whatsGoingOn(s: String): String {
        return modelName
    }

    companion object {
        private var numOfPrintedVehicles: Int = 0
        fun getNumOfPrints(): Int = numOfPrintedVehicles
    }
}

// === Inheritance ===
enum class EngineType {
    ELECTRIC, COMBUSTION
}

class Car(
    modelName: String,
    terrainType: TerrainType,
    val engineType: EngineType
) : Vehicle(modelName, terrainType) {
    override fun buildOutputString(): String {
        return "${super.buildOutputString()} and has a ${capitalizeFirstChar(engineType.toString())} engine"
    }
}

// Example Class with Companion Object
class ExampleClass {
    companion object {
        fun exampleMethod(s: String): String {
            return s.reversed()
        }
    }
}

// === Data Classes ===
data class Contact(
    val firstName: String,
    val lastName: String,
    val mobileNumber: String,
    val street: String? = null,
    val town: String? = null,
    val country: String? = null
)

data class SmallContact(
    val name: String,
    val number: String
)

// === Design Patterns ===

// Flyweight Pattern
enum class PlayerColor {
    BLUE, BLACK
}

class Player private constructor(val playerColor: PlayerColor) {
    private var points: Int = 0

    companion object {
        private var INSTANCES: MutableMap<PlayerColor, Player> = mutableMapOf()

        fun getPlayer(playerColor: PlayerColor): Player {
            return INSTANCES[playerColor] ?: Player(playerColor).also { INSTANCES[playerColor] = it }
        }
    }
}

// Singleton Pattern
class Database private constructor() {
    companion object {
        private var INSTANCE: Database? = null

        fun getDatabase(): Database {
            return INSTANCE ?: build().also { INSTANCE = it }
        }

        private fun build(): Database {
            // Database initialization logic here
            return Database()
        }
    }
}

// Using object keyword for Singleton
object AppContainer {
    val contactTable = listOf<Contact>()
    val playerTable = listOf<Player>()
}

// === Abstract Classes ===
abstract class Superhero {
    abstract val name: String
    abstract fun greet()
}

class Batman : Superhero() {
    override val name = "Batman"
    override fun greet() {
        println("I am $name")
    }
}

class Robin : Superhero() {
    override val name = "Robin"
    override fun greet() {
        println("I am $name, the sidekick")
    }
}
