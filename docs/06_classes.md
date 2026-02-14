# Chapter 6: Classes and Objects

Kotlin is an object-oriented language with modern features. This chapter introduces classes as the basic building blocks 
for modeling data and behavior.

## Basic Classes

Classes are defined using the `class` keyword. They can have properties, methods, and constructors.

```kotlin
class Person(
    val firstName: String,
    val lastName: String
) {
    fun greet() {
        println("Hello, my name is $firstName $lastName")
    }
}
```

In Kotlin, you can define a primary **constructor** directly in the class header, as shown above. The `val` keyword 
indicates that `firstName` and `lastName` are read-only **properties** of the class. If you want them to be mutable, 
use `var` instead. The `greet()` function is a **method** of the `Person` class that prints a greeting using those
properties. Unlike in Python or Java, there is no need for a separate `__init__` or constructor method to initialize 
properties; the primary constructor handles it. Inside the class, you can refer to properties by name without `this.` 
or `self.` unless there is a naming conflict.

??? example "Try it out"
    ```kotlin
    val person = Person("Bruce", "Wayne")
    person.greet()
    ```
    **Expected Result**:
    ```
    Hello, my name is Bruce Wayne
    ```

The following class shows a more complex example with a primary constructor, visibility modifiers, mutable properties, 
an initializer block (`init`), and a companion object for static-like members:

```kotlin
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
```

The `BankAccount` class has a primary constructor that takes an `initialBalance`. Because it has no `val` or `var`, it 
is only a constructor parameter, not a property. The actual `balance` property is initialized in the `init` block based 
on `initialBalance`.<br>
The `init` block runs right after the primary constructor, which makes it a good place for validation and other one-time
setup logic.

??? example "Try it out"
    ```kotlin
    val emptyAccount = BankAccount(-50.0)
    val myBankAccount = BankAccount(100.0)
    ```
    **Expected Result**:
    ```
    initial balance was negative, defaulted to 0.
    Bank account created with an initial balance of 0.0
    Bank account created with an initial balance of 100.0
    ```

The `balance` property is private and cannot be read or written directly from outside the class. Instead, it is modified
through the `deposit()` and `withdraw()` methods and accessed through `getBalance()`.

??? example "Try it out"
    ```kotlin
    // println(myBankAccount.balance) // Compilation error: balance is private
    // myBankAccount.balance = 500.0 // Compilation error: balance is private
    myBankAccount.deposit(50.0)
    myBankAccount.withdraw(20.0)
    println("Final balance: €${myBankAccount.getBalance()}")
    ```
    **Expected Result**:
    ```
    Deposited €50.0. New balance: €150.0
    Withdrew €20.0. New balance: €130.0
    Final balance: €130.0
    ```

The `transactionCount` property is mutable but has a private setter, so it can only be modified from within the class.

??? example "Try it out"
    ```kotlin
    // myBankAccount.transactionCount++ // Compilation error: transactionCount has a private setter
    println("Number of transactions: ${myBankAccount.transactionCount}") //OK
    ```
    **Expected Result**:
    ```
    Number of transactions: 2
    ```

The companion object lets you define members that belong to the class itself rather than to individual instances, 
similar to static members in Java or C#. The `getCreationRules()` function can be called directly on the `BankAccount`
class without creating an instance.

??? example "Try it out"
    ```kotlin
    println(BankAccount.getCreationRules())
    ```
    **Expected Result**:
    ```
    To create a bank account, you need to provide an initial balance. If the initial balance provided is negative, it defaults to 0
    ```

### Open Classes

Classes in Kotlin are `final` by default. For inheritance, they must be marked as `open`:

```kotlin
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
```

Functions marked as `protected` are accessible only within the class and its subclasses, and functions marked as `open` 
can be overridden in subclasses.

??? example "Try it out"
    ```kotlin
    val aircraft = Vehicle("Boing 747", TerrainType.AIR)
    //aircraft.buildOutputString() // Not accessible
    aircraft.print()
    println(Vehicle.getNumOfPrints())
    ```
    **Expected Result**:
    ```
    This is a Boing 747. It operates in Air
    1
    ```

Since `getNumOfPrints()` is defined in the companion object, it can be accessed directly via the class name `Vehicle`.

### Inheritance

The `Vehicle` class can be extended by other classes, for example to specify different types of vehicles like cars, 
which have an engine type:

```kotlin
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
```

The extension is done using the `:` symbol followed by the base class constructor call. The `super` keyword is used 
to access members of the base class like `buildOutputString()`. Since `numOfPrintedVehicles` is defined in the companion
object of the base class, it is shared among all subclasses. Calling `print()` on any subclass increments the same 
counter.

## Data Classes

Data classes are specifically designed for holding data. The compiler automatically generates `equals()` / `hashCode()`, `toString()`, `copy()`, and `componentN()` for destructuring. Data classes can also be marked with `@Serializable` for easy serialization, for example to convert to and from JSON. They are therefore ideal for DTOs (Data Transfer Objects) in networking or database operations. For example, let's assume we have a Contacts table that can be queried using an API. Each returned row can be represented as an instance of the following data class:

```kotlin
data class Contact(
    val firstName: String,
    val lastName: String,
    val mobileNumber: String,
    val street: String? = null,
    val town: String? = null,
    val country: String? = null
)
```

### Copy Function

To manipulate data class instances in an immutable way, the `copy()` function can be used to create modified copies:

```kotlin
var contact = Contact("Bruce", "Wayne", "+123456789")
contact = contact.copy(country = "USA") // Adds country
contact = contact.copy(firstName = "Dick") // Changes first name
```

??? example "Try it out"
    ```kotlin
    var contact = Contact("Bruce", "Wayne", "+123456789")
    println(contact)
    contact = contact.copy(country = "USA")
    println(contact)
    contact = contact.copy(
        firstName = "Dick",
        lastName = "Grayson"
    )
    println(contact)
    ```
    **Expected Result**:
    ```
    Contact(firstName=Bruce, lastName=Wayne, mobileNumber=+123456789, street=null, town=null, country=null)
    Contact(firstName=Bruce, lastName=Wayne, mobileNumber=+123456789, street=null, town=null, country=USA)
    Contact(firstName=Dick, lastName=Grayson, mobileNumber=+123456789, street=null, town=null, country=USA)
    ```

### Destructuring

Like with Pair and Triple, data class instances can be destructured.

```kotlin
data class SmallContact(
    val name: String,
    val number: String
)

val smallContact = SmallContact("Bruce", "123")
val (name, nummer) = smallContact
```

??? example "Try it out"
    ```kotlin
    val smallContact = SmallContact("Bruce", "123")
    val (name, nummer) = smallContact
    println("$name: $number")
    ```
    **Expected Result**:
    ```
    Bruce: 123
    ```

## Design Patterns

Design patterns are proven solutions to common programming problems. Kotlin's language features make many classic design
patterns easy to implement in a concise, readable way. Let's explore a few that fit Kotlin particularly well.

### Flyweight Pattern

The Flyweight pattern is a structural design pattern that **ensures only one instance per key exists**. Instead of 
creating a new object every time one is requested, it reuses existing instances when possible. This is particularly 
useful when you need many objects that share common state.

In the example below, we implement a `Player` class where each player is identified by their color. The pattern ensures 
that for each `PlayerColor`, only one `Player` instance ever exists in memory. A private constructor prevents direct 
instantiation, and the companion object acts as a factory and cache for created instances.

```kotlin
enum class PlayerColor {
    BLUE, BLACK
}

class Player private constructor(val playerColor: PlayerColor) {
    private var points: Int = 0

    companion object {
        private var INSTANCES: MutableMap<PlayerColor, Player> = mutableMapOf()
        
        fun getPlayer(playerColor: PlayerColor): Player {
            return INSTANCES[playerColor] ?: Player(playerColor).also { 
                INSTANCES[playerColor] = it 
            }
        }
    }
}
```

??? example "Try it out"
    ```kotlin
    val blue = Player.getPlayer(PlayerColor.BLUE)
    val blue2 = Player.getPlayer(PlayerColor.BLUE)
    println(blue === blue2) // Reference equality check
    ```
    **Expected Result**:
    ```
    true
    ```

### Singleton Pattern

The Singleton pattern is a creational design pattern that **ensures only one instance of a class exists** throughout 
the application's lifecycle. This is useful for resources that should be shared globally, such as database connections, 
configuration managers, or logging systems.

In the example below, we implement a `Database` class as a singleton. No matter how many times `getDatabase()` is called,
the same `Database` instance will be returned. This prevents multiple database connections from being created 
unnecessarily and keeps access consistent. A private constructor blocks external instantiation, while a nullable 
`INSTANCE` variable and the `getDatabase()` factory method provide lazy, controlled access.

```kotlin
class Database private constructor() {
    companion object {
        private var INSTANCE: Database? = null

        fun getDatabase(): Database {
            return INSTANCE ?: build().also { INSTANCE = it }
        }

        private fun build(): Database {
            //Initialization code
            return Database()
        }
    }
}
```

??? example "Try it out"
    ```kotlin
    val db1 = Database.getDatabase()
    val db2 = Database.getDatabase()
    println(db1 === db2) // Reference equality check
    ```
    **Expected Result**:
    ```
    true
    ```

### Object Declaration

While the traditional Singleton pattern works well, Kotlin provides a more elegant and concise syntax for creating 
singletons: **object declarations**. An `object` in Kotlin is both a class declaration and a single instance of that 
class, combined into one statement. The Kotlin compiler handles all the singleton logic automatically.

In the example below, we create an `AppContainer` object that serves as a dependency injection container for the 
application. The `contactTable` property uses **lazy initialization** with the `by lazy` delegate, meaning it will not 
be created until it is first accessed. This is a common pattern in Android development for managing application-level 
dependencies.

```kotlin
object AppContainer {
    val contactTable: List<String> by lazy {
        listOf()
    }
}
```

!!! tip "Lazy Initialization"
    `by lazy` initializes the property only on first access.

## Abstract Classes

Abstract classes cannot be instantiated and serve as base classes. They can contain both abstract methods (without 
implementation) and concrete methods (with implementation). Subclasses must implement the abstract methods. In contrast 
to interfaces, abstract classes can have state (properties) that is shared among subclasses, like the `callCount` below.

```kotlin
abstract class Person(protected val name: String) {
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

class Batman : Person("Bruce") {
    override fun greet() {
        println("I am Batm.. ah no shit I meant I am $name")
        logCalls()
    }
}

class Robin : Person("Dick") {
    override fun greet() {
        println("Hi, I am $name")
        logCalls()
    }
}
```

??? example "Try it out"
    ```kotlin
    val bruce = Batman()
    val dick = Robin()
    val dick2 = Robin()
    bruce.greet()
    dick.greet()
    dick2.greet()
    ```
    
    **Expected Result**:
    ```
    I am Batm.. ah no shit I meant I am Bruce
    I was called 1 times but in general there were already 1 calls.
    Hi, I am Dick
    I was called 1 times but in general there were already 2 calls.
    Hi, I am Dick
    I was called 1 times but in general there were already 3 calls.
    ```

## Interfaces

Interfaces define **contracts** that classes must implement. They specify what a class must do, but not how it does it.
Unlike abstract classes, interfaces cannot hold state (non-initialized properties), but they can still declare abstract 
properties and methods, as well as default method implementations and properties with custom getters.

Interfaces are particularly useful for defining common behavior across unrelated classes. For example, in Android 
development, navigation destinations share common properties regardless of their specific screen implementation:

```kotlin
interface NavigationDestination {
    val route: String        // Navigation route identifier
    val titleRes: Int        // Resource ID for the screen title
}

object ContactDetailsScreen : NavigationDestination {
    override val route = "contact_details"
    override val titleRes = 0
}
```

A class or object can implement multiple interfaces (multiple inheritance of behavior), which is not possible with classes:

```kotlin
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
```

??? example "Try it out"
    ```kotlin
    val button = Button()
    button.click()
    button.focus()
    button.blur()
    ```
    
    **Expected Result**:
    ```
    Button clicked
    Button focused
    Lost focus
    ```

When choosing between interfaces and abstract classes, use interfaces for pure contracts without shared state, and 
abstract classes when you want to share state or implementation. Interfaces support multiple inheritance; abstract 
classes do not.

## Class Types Comparison

| Type                 | Primary Use                        | Instantiable         | Inheritance          | Class-Level Members     |
|----------------------|------------------------------------|----------------------|----------------------|-------------------------|
| **Regular Class**    | General OOP, custom behavior       | Yes                  | Single inheritance   | Via companion object    |
| **Open Class**       | Base class for inheritance         | Yes                  | Can be extended      | Via companion object    |
| **Data Class**       | Data containers (DTOs, models)     | Yes                  | Can extend a class   | Via companion object    |
| **Abstract Class**   | Shared base + contracts            | No                   | Single inheritance   | Via companion object    |
| **Interface**        | Pure contracts and shared behavior | No                   | Multiple inheritance | Not applicable          |
| **Object**           | Singleton or utility holder        | No (single instance) | Can extend/implement | N/A (it is the instance) |
| **Companion Object** | Class-level helpers and factories  | No                   | N/A                  | Yes (static-like)       |

## Summary

- **Classes** are the foundation of object-oriented programming in Kotlin
- **Open classes** allow inheritance - classes are `final` by default for safety
- **Inheritance** uses the `:` syntax and enables code reuse through extension
- **Data classes** automatically generate `equals()`, `hashCode()`, `toString()`, `copy()`, and destructuring
- **Copy function** enables immutable data manipulation of data class instances
- **Companion objects** provide class-level (static-like) members
- **Design Patterns**:
    - **Flyweight**: Ensures only one instance per key (e.g., player color) exists
    - **Singleton**: Ensures only one instance exists (manual or via `object`)
    - **Object declarations**: Kotlin's elegant, thread-safe singleton syntax
- **Abstract classes** define shared implementation and state for subclasses
- **Interfaces** define pure contracts and support multiple inheritance

## Further Reading

- [Kotlin Documentation: Classes](https://kotlinlang.org/docs/classes.html)
- [Kotlin Documentation: Data Classes](https://kotlinlang.org/docs/data-classes.html)
- [Kotlin Documentation: Objects](https://kotlinlang.org/docs/object-declarations.html)

[← Back to Chapter 5: Functional Patterns](05_functional_patterns.md) | [Continue to Chapter 7: Coroutines →](07_coroutines.md)