class Student(firstName: String, var lastName: String = "Lord", var age: Int = 0) {
    var firstName = firstName
        get() {
            return "FirstName: $field"
        }
        set(value) {
            println("$value is assigned to firstName property.")
            field = value
        }
}