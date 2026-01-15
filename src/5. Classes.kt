//Classes and Objects
enum class TerrainType{
    LAND, WATER, AIR
}

enum class EngineType {
    ELECTRIC, COMBUSTION
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

class Car(
    modelName: String,
    terrainType: TerrainType,
    val engineType: EngineType
) : Vehicle(modelName, terrainType) {
    override fun buildOutputString(): String {
        return "${super.buildOutputString()} and has a ${capitalizeFirstChar(engineType.toString())} engine"
    }
}

//class types
//Data class
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
    val nummer: String
)

// Flyweight
enum class PlayerColor {
    BLUE, BLACK
}

class Player private constructor (val playerColor: PlayerColor) {
    private var points: Int = 0

    companion object {
        private var INSTANCES: MutableMap<PlayerColor, Player> = mutableMapOf()
        fun getPlayer(playerColor: PlayerColor): Player {
            return INSTANCES[playerColor] ?: Player(playerColor).also { INSTANCES[playerColor] = it }
        }
    }
}

//Singleton
class Database private constructor() {
    companion object{
        private var INSTANCE: Database? = null

        fun getDatabase(): Database {
            return INSTANCE ?: build().also { INSTANCE = it }
        }

        private fun build(): Database {
            //Stuff
            return Database()
        }
    }
}

object AppContainer {
    val contactTable: List<String> by lazy {
        listOf()
    }
}

//abstract class
abstract class Person(protected val name: String) {
    private var callCount: Int = 0
    protected fun logCalls() {
        callCount++
        println("Schon $callCount mal gecallt.")
    }

    abstract fun greet()
}

class Dominik: Person("Dominik"){
    override fun greet() {
        println("Hallo, mein Name ist $name")
        logCalls()
    }
}

class Anna: Person("Anna"){
    override fun greet(){
        println("Hi, ich bin $name")
        logCalls()
    }
}

//Interface
interface NavigationDestination {
    val route: String
    val titleRes: Int
}

object ContactDetailsScreen: NavigationDestination {
    override val route = "contact_details"
    override val titleRes = 0
}


