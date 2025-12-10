import java.math.BigInteger
import kotlin.math.pow

//Primitives

//Boolean
val wahr: Boolean = true
val falsch = false
val und: Boolean = true && false
val oder = wahr || falsch

//Strings
val vorname: String = "Dominik"
val nachname = "Pengel"
val fullName = "$vorname $nachname"//vorname + nachname
//Chars
val firstLetterChar: Char = 'D' + 1
val firstLetterStrings: String = "$firstLetterChar"

//Numbers
val age: Short = 36 //16bit
val salary: Int = 2147483647 // 32bit
val salaryAfterPromotion: Long = salary + 1L //64bit
val veryLargeNumber = BigInteger("123456789123456789123456789123456789123456789")

val hydrogenIonizationEnergy: Float = 13.36F
val precisionOfFloat: Float = 12345612.0F
val debtOfGermanState = -2.7E32

val power1 = 2.0.pow(3)
val power2 = Math.pow(2.0, 3.0)
val power3 = 1 shl 3 // 0001 -> 1000

//mutable vs immutable
var mutableWahr: Boolean = true

//const
const val justWahr = true //compile-time constant

//null
val nischt = null

//unit
val einheit = Unit


