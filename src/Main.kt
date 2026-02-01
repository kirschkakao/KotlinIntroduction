fun main() {
    println("=== Kotlin Introduction ===\n")

    // ===== Chapter 1: Primitives =====
    // unchangeable = "New"  // Compilation error!
    // mutableTrue = false   // OK

    // println(fullName)
    // println(firstLetterChar)
    // println(charInString)
    // println(salaryAfterPromotion)
    // println(newSalary)
    // println(sum)
    // println(power1)
    // println(power2)
    // println(power3)

    // ===== Chapter 2: Collections =====
    // val (x, y) = coordinate
    // println("x: $x, y: $y")

    // println(germanStates)
    // println(newGermanStates)

    // germanStates.add("Niedersachen") // This will cause a compilation error
    // germanStates[0] = "Hamburg" // This will cause a compilation error

    // mutableGermanStateSet.add("Bayern")
    // println(mutableGermanStateSet)
    // println(mutableGermanStates)

    // println(sortedStateSet)

    // println(authorMap["J.R.R. Tolkien"])

    // mutableAuthorMap["J.K. Rowling"] = listOf("Harry Potter")
    // println(mutableAuthorMap)

    // ===== Chapter 3: Functions =====
    // greet("Bruce")
    // println(capitalizeFirstChar("bRucE"))
    // smartGreet("bRucE")
    // freeGreet("bRucE", ::capitalizeFirstChar)
    // freeGreet("Bruce") { it.reversed() }
    // freeGreet("Bruce") { it.toCharArray().sorted().joinToString("") }
    // println(GermanState.BAYERN.next())
    // println("hELLO wORLD".capitalizeFirstChar2())
    // println(listOf(1, 2, 3).newSum())
    // println(listOf(1.5, 2.5, 3.0).newSum())
    // println(CardinalDirections.NORTH.next())
    // listOf(1).printTypeInfo()

    // ===== Chapter 4: Null Safety & Scope Functions =====
    // notNullable = null  // Compilation error!
    // nullable = null  // OK

    // Safe Call Operator Examples
    // val length = nullable?.length
    // println(length)

    // Elvis Operator Examples
    // val length2 = nullable?.length ?: 0
    // println(length2)

    // println(foo("Hello"))
    // println(foo(null))  // Compilation error!
    // println(bar("Hello"))
    // println(bar(null))

    // printBooksFromAuthor("J.R.R. Tolkien")
    // printBooksFromAuthor("Unknown Author")

    // Not-Null Assertion
    // val length3 = nullable!!.length  // Throws NPE if nullable is null

    // Scope Functions
    // letExample("Kotlin")
    // letExample()
    // runExample()
    // alsoExample()
    // applyExample()
    // withExample()

    // ===== Chapter 5: Functional Patterns =====
    // println(sanitizedList)
    // println(cleanList)
    // println(sortedDistinctNameList)
    // println(frequencyNameList)
    // println(summedList)
    // println(stringResult)
    // println(otherSum)
    // println(fibonacci(8))

    // ===== Chapter 6: Classes =====
    // val person = Person("Alice", "Smith")
    // person.greet()

    // val aircraft = Vehicle("Boeing 747", TerrainType.AIR)
    // aircraft.print()
    // println(Vehicle.getNumOfPrints())

    // val car = Car("VW Golf", TerrainType.LAND, EngineType.COMBUSTION)
    // car.print()
    // println(Vehicle.getNumOfPrints())
    // aircraft.print()
    // println(Vehicle.getNumOfPrints())

    // var contact = Contact("Bruce", "Wayne", "+123456789")
    // println(contact)
    // contact = contact.copy(country = "USA")
    // println(contact)
    // contact = contact.copy(firstName = "Dick", lastName = "Grayson")
    // println(contact)

    // val smallContact = SmallContact("Bruce", "123")
    // val (name, number) = smallContact
    // println("$name: $number")

    // val blue = Player.getPlayer(PlayerColor.BLUE)
    // val blue2 = Player.getPlayer(PlayerColor.BLUE)
    // println(blue === blue2)

    // val db1 = Database.getDatabase()
    // val db2 = Database.getDatabase()
    // println(db1 === db2)

    // val bruce = Batman()
    // al dick = Robin()
    // val dick2 = Robin()
    // bruce.greet()
    // dick.greet()
    // dick2.greet()

    // val button = Button()
    // button.click()
    // button.focus()
    // button.blur()

    // ===== Chapter 7: Coroutines =====
    // println("start")
    // normalThread()
    // coroutine()
    // coroutine2()
    // lightweightExample()

    // Measuring execution time (uncomment to use)
    // val time = measureTimeMillis {
    //     notParallelExample()
    // }
    // println("Sequential: $time ms")

    // val time2 = measureTimeMillis {
    //     awaitExample()
    // }
    // println("Parallel: $time2 ms")

    // val time3 = measureTimeMillis {
    //     awaitAllExample()
    // }
    // println("AwaitAll: $time3 ms")
}