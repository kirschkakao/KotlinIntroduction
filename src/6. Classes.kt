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

class BankAccount(
    initialBalance: Double,
) {
    private var balance: Double = 0.0

    var transactionCount: Int = 0
        private set

    init {
        if (initialBalance >= 0) balance = initialBalance
        else println("initial balance was negative, defaulted to 0.")

        println("Bank account created with an initial balance of $balance")
    }

    fun deposit(amount: Double) {
        balance += amount
        transactionCount++
        println("Deposited €$amount. New balance: €$balance")
    }

    fun withdraw(amount: Double) {
        balance -= amount
        transactionCount++
        println("Withdrew €$amount. New balance: €$balance")
    }

    fun getBalance(): Double = balance

    companion object {
        fun getCreationRules(): String {
            return "To create a bank account, you need to provide an initial balance. " +
                    "If the initial balance provided is negative, it defaults to 0"
        }
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
abstract class Hero(protected val name: String) {
    private var ownCallCount: Int = 0

    protected fun logCalls() {
        callCount++
        ownCallCount++
        println("I was called $ownCallCount times but in general there were already $callCount calls.")
    }

    abstract fun greet()

    companion object {
        private var callCount: Int = 0
    }
}

class Batman : Hero("Bruce") {
    override fun greet() {
        println("I am Batm.. ah no shit I meant I am $name")
        logCalls()
    }
}

class Robin : Hero("Dick") {
    override fun greet() {
        println("Hi, I am $name")
        logCalls()
    }
}

// === Interfaces ===
interface Clickable {
    fun click()
}

interface Focusable {
    fun focus()
    fun blur() {
        println("Lost focus")  // Default implementation
    }
}

class Button : Clickable, Focusable {
    override fun click() {
        println("Button clicked")
    }

    override fun focus() {
        println("Button focused")
    }
    // blur() is inherited with default implementation
}
