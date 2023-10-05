import Result
import java.text.ParseException
import java.util.*
import kotlin.reflect.full.memberProperties

fun KotlinPrimitiveTypes() {
    // Static variable => val, otherwise var
    var userEmail = "thanhledev@gmail.com"
    userEmail = "thanhleppger@gmail.com"
    println("My email: $userEmail")
    // basic variable types
    // String
    val userName: String = "Thanh Le"
    println("Hello $userName")

    // Statically types
    // variable's type cannot be changed
    // userEmail = 19.0 => error

    // type inference
    var newName = "Jack Dawson"
    var newAge = 19

    // Integer type variables
    val maxIntValue = Int.MAX_VALUE
    val minIntValue = Int.MIN_VALUE
    println("Int max value is $maxIntValue ; Int min value is $minIntValue")

    // Byte type variables
    val newNameBytes = newName.toByteArray()
    println("Each byte in the newNameBytes is:")
    for (byte in newNameBytes)
        println(byte)

    // Short type variables
    val normalShortValue = 3452
    val minShortValue = Short.MIN_VALUE
    val maxShortValue = Short.MAX_VALUE
    println("Short variables: $normalShortValue, minValue: $minShortValue, maxValue: $maxShortValue")

    // Long type variables
    val normalLongValue = 1000012345677
    val minLongValue = Long.MIN_VALUE
    val maxLongValue = Long.MAX_VALUE
    println("Long variables: $normalLongValue, minValue: $minLongValue, maxValue: $maxLongValue")

    // Float type variable
    val normalFloatValue: Float = 2.5f
    // Double type variable
    val normalDoubleValue: Double = 2.6
    // Use Float or Double ? The precision of a floating point value indicates how many digits the value can have after
    // the decimal point. The precision of Float is only six or seven decimal digits, while Double variables have
    // a precision of about 15 digits. Therefore it is safer to use Double for most calculations.

    // Char type variable
    val myCharValue: Char = 'A'
    // Boolean type variable
    val myBooleanValue: Boolean = true
    println("myCharValue is $myCharValue and myBooleanValue is $myBooleanValue")
}

fun KotlinOperators() {
    val x = 5
    val y = 3


    println("$x + $y = ${x + y} // using placeholder \${x + y}")
    println("$x - $y = ${x - y} // using placeholder \${x - y}")
    println("$x * $y = ${x * y} // using placeholder \${x * y}")
    println("$x / $y = ${x / y} // using placeholder \${x / y}")
    println("$x % $y = ${x % y} // using placeholder \${x % y}")

    // shorthands operator
    var result = x + y

    result += 2 // equals to result = result + 2
    result -= 2 // equals to result = result - 2
    result *= 2 // equals to result = result * 2
    result /= 2 // equals to result = result / 2

    // shorthand increase/decrease
    var xValue = 0
    println("x_value = ${++xValue}") // increase by 1 and use to print
    // x_value++ => use then increase by 1
}

fun KotlinStatement() {
    val userLogged = false

    if (userLogged) {
        println("User logged in!")
    } else {
        println("Please log in to continue.")
    }

    print("Enter a price: ")
    val itemPrice = readln().toInt()

    if (itemPrice < 100) {
        println("Item is under $100")
    } else if (itemPrice in 100..199) {
        println("Item is between $100 and $200")
    } else {
        println("Item is over $200")
    }

    // When statement
    print("Enter the time: ")
    val currentHour = readln().toInt()

    when(currentHour) {
        6,7,8,9,10,11,12 -> {
            println("Good morning!")
            println("Have a good breakfast.")
        }
        13,14,15,16,17,18 -> println("Good afternoon!")
        19,20,21,22,23,0,1,2,3,4,5 -> println("Good evening!")
        else -> println("Invalid time")
    }
}

fun KotlinNullable() {
    print("Enter a string: ")
    var text: String? = readlnOrNull()
    // surrounding by null check
    if (text != null) {
        println("text length is: ${text.length}")
    } else {
        println("You have entered null value.")
    }
    print("Enter another string: ")
    var newText: String? = readlnOrNull()
    println("newText length is: ${newText?.length}")

    print("Enter basedText string: ")
    var basedText: String = readln()
    val someText = if (basedText.length > 0) basedText else "basedText is empty or null."
    println("someText value is $someText")
}

// basic void function with parameters
fun sayHello(name: String, age: Int) {
    println("Hello $name! Your age is $age")
}

// basic return type function
fun getMax(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// function overloading: same name but with different parameter types (aka signatures)
fun getMax(a: Double, b: Double): Double {
    return if (a > b) a else b
}

fun sendMessage(name: String, message: String = "Default message") {
    println("Send '$message' to $name")
}

// vararg keyword
fun badSum(a: Int, b: Int, c: Int, d: Int): Int {
    return a + b + c + d
}

fun sum(vararg numbers: Int): Int {
    var result = 0
    for (n in numbers) result += n
    return result
}

fun kotlinForLoop() {
    println("For-loop examples")
    // upward
    for (i in 1 until 10)
        println("i is $i")

    // downward
    for (j in 10 downTo 1)
        println("j is $j")

    // only odd numbers => using step
    // until is excluded ( < ), .. is included ( <= )
    println("The odd numbers from 1 to 10 are: ")
    for (k in 1 .. 10 step 2)
        print("$k ")
    println("")
}

fun kotlinWhileLoop() {
    println("while-loop example")
    var number = 0
    while (number < 10) {
        println("number is $number")
        number++
    }

    println("while-loop with break example")
    var decreNum = 10
    outer@ while (decreNum > 0) {
        if (decreNum == 3) break@outer
        println("*** decreNum = $decreNum")
        decreNum--
    }

    println("do-while-loop example")
    var decreNum2 = 10
    do {
        println("*** decreNum2 = $decreNum2")
        decreNum2--
    } while (decreNum2 >= 3)

    println("")
}

fun findMinMax(arr: Array<Int>, order: Boolean = true): Int {
    var searchResult: Int = arr[0]
    if (order) {
        for (n in arr) {
            if (n > searchResult) {
                searchResult = n
            }
        }
    } else {
        for (n in arr) {
            if (n < searchResult) {
                searchResult = n
            }
        }
    }

    return searchResult
}

fun kotlinArray() {
    val names: Array<String> = arrayOf("Jack", "John", "Dave")
    println("First name: ${names[0]}")
    // edit element in array
    println("Second name: ${names[1]}")
    names[1] = "Mary"
    println("Second name: ${names[1]}")

    val mixTypes = arrayOf("name 1", 4, 2, 4, 5, true)

    for (elm in mixTypes) {
        println("elm: $elm")
    }

    val numbers = arrayOf(20,34,11,21,100,60,87)
    val minValue = findMinMax(numbers, false)
    val maxValue = findMinMax(numbers)
    println("array numbers => minValue = $minValue, maxValue = $maxValue")
}


fun main(args: Array<String>) {
    //KotlinPrimitiveTypes()
    //KotlinOperators()
    //KotlinStatement()
    //KotlinNullable()
    /*
    sayHello("Thanh", 36)
    val x = 12
    val y = 11
    println("The maximum number between $x and $y is ${getMax(x, y)}")

    val a = 1.4
    val b = 22.2
    println("The maximum number between $a and $b is ${getMax(a, b)}")

    val userName = "Thanh Le"
    val message = "Good morning"
    sendMessage(userName, message)
    // using default value in function parameter definition
    sendMessage(userName)

    // using varArg
    println(sum(1,2,3,4,5,6,7,8,9,10))
    // for loop
    kotlinForLoop()
    // while loop
    kotlinWhileLoop()
    */
    // array example
    // kotlinArray()

    // OOP examples
    /*val myCar = Car(name = "Tesla", "S", "white", 4)
    myCar.move()
    myCar.brake()

    val thanhle = User(name = "Thanh", lastName = "Le", 36)
    thanhle.description()
    val marcel = User(name = "Marcel")
    marcel.description()
    val christian = User(name = "Sith", "Lord")
    christian.description()

    val newStudent = Student("Sith", "Lord")
    println("newStudent:${newStudent.firstName}, LastName: ${newStudent.lastName}, age: ${newStudent.age}")
    newStudent.firstName = "Jack"
    println("newStudent:${newStudent.firstName}, LastName: ${newStudent.lastName}, age: ${newStudent.age}")*/

    // OOP - Companion object === Java static method

    // val calculator = Calculator()
    // println("5 + 3 = ${Calculator.sum(5,3)}")

    // OOP - Singleton pattern using data class

    // val db1 = Database.getInstance()
    // val db2 = Database.getInstance()
    // println("db1 object Id: $db1")
    // println("db2 object Id: $db2")

    // OOP - Singleton pattern using object

    // preferably use with thread-safe
    // println(DatabaseObj)
    // println(DatabaseObj)

    // Lazy initialization

    //val user1 = UserLazy("Alex", "Dobbin", 23)
    //val user2 by lazy {
    //    UserLazy("Lazy", "User", 10)
    //}
    // only when uncomment this line then user2 was initialized
    // println(user2.firstName)

    // Enum
    /*for (direction in Direction.values()) {
        println("${direction.name}: ${direction.dir} - distance: ${direction.distance}")
        println("Using enum function:")
        direction.printData()
    }

    val myDirection = Direction.valueOf("east".uppercase(Locale.getDefault()))

    when (myDirection) {
        Direction.NORTH -> println("I want to go north")
        Direction.SOUTH -> println("I want to go south")
        Direction.EAST -> println("I want to go east")
        Direction.WEST -> println("I want to go west")
    }*/

    // Inner class
    /*val listView = ListView(arrayOf("Name 1", "Name 2", "Name 3", "Name 4"))
    listView.ListViewItem().displayItem(2)

    // OOP Challenge
    var jackAcc = Account("Jack")
    jackAcc.deposit(1000)
    jackAcc.withdraw(500)
    jackAcc.deposit(-200)
    jackAcc.withdraw(2000)

    println("Jack current balance is $${jackAcc.calculateBalance()}")*/

    // OOP Inheritance - 1
    /*val ice = Train("ICE train", "white", 1, 20)
    val a380 = Plane("Airbus A380", "blue", 4, 16)

    ice.move()
    a380.move()

    ice.stop()
    a380.stop()*/

    // OOP Inheritance - 2
    /*val view = View()
    val button = Button("button", "top")
    val roundButton = RoundButton("round button", "right", 4)

    view.draw()
    button.draw()
    roundButton.draw()*/

    // OOP sealed class
    /*val successResult = Result.Success("Success!!!")
    val failedResult = Result.Error.RecoverableError(java.text.ParseException("1", 1), "parse-exception")

    getSealedClassData(successResult)*/

    // OOP Interface 2 && Object expression
    /*val onClickListener = ClickListener()

    val loginButton = AndroidButton("Login", 211, onClickListener)
    val signUpButton = AndroidButton("Sign Up", 222, object : OnClickListener {
        override fun onClick() {
            TODO("Not yet implemented")
        }
    })*/

    // OOP Delegation - Class delegation
    // Read more: https://blog.devgenius.io/a-gentle-introduction-to-delegation-in-kotlin-a1c4f19ec589
    // Check out Software Interface, ProprietarySoftware, FreeSoftware, and WordProcessor classes

    // OOP Delegation - using by keyword
    // Check out WordProcessorV2 class

    // OOP Delegation - Property delegate
    // Checkout Delegate, UserPropertyDelegate classes
    /*var userDelegate = UserPropertyDelegate().apply {
        firstName = "John"
        lastName = "Doe"
    }

    val userFirstName = userDelegate.firstName
    val userLastName = userDelegate.lastName*/

    // List
    /*val names = mutableListOf("Name 1", "Name 2", "Name 3")

    names.add("Name 4")
    showList(names)
    names.reverse()
    showList(names)*/

    // Set
    /*val user1 = User("name 1", "lastname 1", 0)
    val user2 = User("name 2", "lastname 1", 0)
    val user3 = User("name 3", "lastname 1", 0)
    val user4 = User("name 4", "lastname 1", 0)
    val user5 = User("name 5", "lastname 1", 0)
    val user6 = User("name 6", "lastname 1", 0)
    val user7 = User("name 6", "lastname 1", 0)

    // users set has duplication of user6 and user7 because class use the equals function
    // solution? => change to data class User
    val users = mutableSetOf(user1, user2, user3, user4, user5, user6, user7)

    users.forEach { println(it) }*/

    // Map
    /*val users = mutableMapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John")
    users[5] = "Vlad"
    println("users maps elements: $users")
    println("Remove element has key=2")
    users.remove(2)
    users.forEach { i, s -> println("$i -> $s") }*/

    // Mapping
    /*val numbers = setOf(1,2,3,4,5)
    println(numbers.map { if (it == 2) it * 100 else it * 10 })

    val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3, "key 4" to 4)
    println(numbersMap.mapKeys { it.key.uppercase(Locale.getDefault()) })
    println(numbersMap.mapValues { it.value + it.key.length })*/

    // Zipping
    val colors = listOf("red", "brown", "gray")
    val animals = listOf("fox", "bear", "wolf")
    // => create pairs
    println(colors.zip(animals))
    println(colors.zip(animals) { color, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is color $color" })

    // Pair => https://www.geeksforgeeks.org/pair-in-kotlin/
    val (x,y) = Pair(1, "Geeks")
    println(x)
    println(y)

    // pair properties
    val myPair = Pair("Hello Geeks", "This is Kotlin tutorial")
    println(myPair.first)
    println(myPair.second)

    val myList = myPair.toList()
    println(myPair)
    println(myList)

    // Associate
    println(colors.associateWith { it.length })
    println(animals.associateBy { it.first().uppercase() })
    println(animals.associateBy(keySelector = {it.first().uppercase()}, valueTransform = {it.length}))

    // Flatten
    val numberSets = listOf(setOf(1,2,3), setOf(4,5,6), setOf(7,8,9))
    println("Not flattening list")
    for (numberSet in numberSets) {
        for (number in numberSet) {
            print("$number ")
        }
        println()
    }

    println("Flattening list")
    val numberSetsFlatten = numberSets.flatten()
    for (ele in numberSetsFlatten) {
        print("$ele ")
    }
    println("")

    // String representations
    val numberStrings = listOf("one", "two", "three", "four")
    println(numberStrings.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    val numberRange = (1 .. 100).toList()
    println("numberRange: ${numberRange.joinToString(limit = 20, truncated = "<...>")}")

    // Filtering
    val longerThanThreeCharacter = numberStrings.filter { it.length > 3 }
    println("Numbers have more than 3 characters: $longerThanThreeCharacter")

    val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3, "key 101" to 101)
    val filterNumbersMap = numbersMap.filter { it.key.endsWith("1") && it.value > 100 }
    println("filterNumbersMap: $filterNumbersMap")

    val filteredIdx = numberStrings.filterIndexed { index, value -> index != 0 && value.length < 5 }
    println("filteredIdx: $filteredIdx")
    val filteredNot = numberStrings.filterNot { it.length <= 3 }
    println("filteredNot: $filteredNot")

    // mixedList
    val mixedList = listOf(1,3,2,'A','B','C',"Hello World","Alex", false, true)
    mixedList.filterIsInstance<Int>().forEach { println(it) }

    // Partition
    val (match, rest) = numberStrings.partition { it.length > 3 }
    println("Partition: match=$match, rest=$rest")

    // test predicates
    println("Any ends with e? ${numberStrings.any { it.endsWith("e") }}")
    println("None ends with w? ${numberStrings.none { it.endsWith("w")}}")
    println("All have length more than 1? ${numberStrings.all { it.length > 1 }}")
}

fun getSealedClassData(result: Result) {
    when(result) {
        is Result.Error.RecoverableError -> result.showMessage()
        is Result.Error.NonRecoverableError -> result.showMessage()
        is Result.Success -> result.showMessage()
        is Result.Progress -> result.showMessage()
    }
}

fun showList(names: MutableList<String>) {
    println("Show elements of names: ")
    names.forEach{
        println(it)
    }
}