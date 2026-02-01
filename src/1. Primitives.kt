import java.math.BigInteger
import kotlin.math.pow

// ===== Chapter 1: Primitive Data Types =====

// === Typing ===
val explicit: String = "I am a String"  // Explicit type declaration
val implicit = 42                        // Type inferred as Int

// === Mutability: val vs var ===
val unchangeable = "I stay the same"
var mutableTrue: Boolean = true

// === Boolean ===
val thisIsTrue: Boolean = true
val thisIsFalse = false

// Logical Operators
val and: Boolean = true && false  // false
val or = true || false             // true

// === Strings and Chars ===
val name: String = "Bruce"
val surname = "Wayne"
val fullName = "$name $surname"  // "Bruce Wayne"

// Chars
val letter: Char = 'D'
val letterCode: Int = letter.code  // 68
val firstLetterChar: Char = 'D' + 1  // 'E'
val charInString = "First letter after D is $firstLetterChar"

// === Numbers ===

// Integers
val age: Short = 36                    // 16 bit
val salary: Int = 2147483647           // 32 bit
val salaryAfterPromotion: Long = salary + 1L  // 64 bit

// Overflow example
val newSalary = salary + 1  // -2147483648 (overflow!)

// Unsigned Integers
val positiveAge: UByte = 36u          // 8 bit
val positiveYear: UShort = 30000u    // 16 bit
val positiveSalary: UInt = 3000000000u // 32 bit
val positiveBigSalary: ULong = 5000000000uL // 64 bit

// Very Large Numbers
val veryLargeNumber = BigInteger("123456789123456789123456789123456789123456789")
val anotherLargeNumber = BigInteger("987654321987654321987654321987654321987654321")
val sum = veryLargeNumber + anotherLargeNumber

// Floating-Point Numbers
val hydrogenIonizationEnergy: Float = 13.36F
val precisionOfFloat = 12345612.0F

// Powers
val power1 = 2.0.pow(3)
val power2 = Math.pow(2.0, 3.0)
val power3 = 1 shl 3 // 0001 -> 1000

// Null
val nothing = null

// Unit
val noReturn = Unit
