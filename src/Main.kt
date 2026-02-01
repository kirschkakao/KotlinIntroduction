fun main() {
    println("=== Kotlin Introduction ===\n")

    // ===== Chapter 1: Primitives =====
    // println(explicit)
    // println(implicit)
    // println(unchangeable)
    // println(thisIsTrue)
    // println(fullName)
    // println(firstLetterChar)
    // println(charInString)
    // println(age)
    // println(newSalary)
    // println(veryLargeNumber + anotherLargeNumber)
    // println(power1)

    // ===== Chapter 2: Collections =====
    // val (x, y) = coordinate
    // println("x: $x, y: $y")
    // println(germanStates)
    // println(germanStateSet)
    // mutableGermanStates.add("Hessen")
    // println(mutableGermanStates)
    // println(authorMap)
    // mutableAuthorMap["J.K. Rowling"] = listOf("Harry Potter")
    // println(mutableAuthorMap)
    // println(GermanState.BAYERN.next())

    // ===== Chapter 3: Functions =====
    // greet("Bruce")
    // println(capitalizeFirstChar("bRucE"))
    // smartGreet("bRucE")
    // freeGreet("bRucE", ::capitalizeFirstChar)
    // freeGreet("Bruce") { it.reversed() }
    // freeGreet("Bruce") { it.toCharArray().sorted().joinToString("") }
    // println(GermanState.BAYERN.next())
    // println(Direction.NORTH.next())
    // listOf(1).printTypeInfo()
    // println(listOf(1, 2).newSum())

    // ===== Chapter 4: Null Safety & Scope Functions =====
    // println(foo("Hello"))
    // // println(foo(null))  // Compilation error!
    // println(bar("Hello"))
    // println(bar(null))

    // Safe Call Operator Examples
    // val length = nullable?.length
    // println(length)

    // Elvis Operator Examples
    // val length2 = nullable?.length ?: 0
    // println(length2)

    // Not-Null Assertion (use with caution!)
    // val length3 = nullable!!.length  // Throws NPE if nullable is null

    // Scope Functions
    // letExample()
    // applyExample()
    // alsoExample()
    // runExample()
    // withExample()

    // ===== Chapter 5: Functional Patterns =====
    // println(sanitizedList)
    // println(sortedDistinctNameList)
    // println(frequencyNameList)
    // println("Sum: $summedList, Other Sum: $otherSum")
    // printBooksFromAuthor("J.R.R. Tolkien")
    // printBooksFromAuthor("Unknown Author")
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
    // val black = Player.getPlayer(PlayerColor.BLUE)
    // println(blue === black)  // true (same instance)

    // val batman = Batman()
    // val robin = Robin()
    // batman.greet()
    // robin.greet()

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

    // downloadMultipleFiles()
}