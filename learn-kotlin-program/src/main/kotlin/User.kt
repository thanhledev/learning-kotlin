class User(var name: String, var lastName: String = "LastName", var age: Int = 0) {
    constructor(name:String): this(name, "User", 0) {
        println("2nd constructor")
    }
    constructor(name: String, lastName: String): this (name, "User2", 0) {
        println("3rd constructor")
    }

    fun description() {
        println("User: $name, $lastName. Age: $age")
    }
}