import java.util.*
import kotlin.Comparator

data class Laptop(val brand: String, val ram: Int, val released: Date, val price: Double) : Comparable<Laptop> {
    override fun compareTo(other: Laptop): Int {
        return if (this.price > other.price) {
            println("In if statement: swapping ${this.brand} with ${other.brand}")
            1
        } else if (this.price < other.price) {
            println("In if statement: swapping ${this.brand} with ${other.brand}")
            -1
        } else {
            0
        }
    }
}

class ComparatorRam: Comparator<Laptop> {
    override fun compare(laptop1: Laptop, laptop2: Laptop): Int {
        return if (laptop1.ram > laptop2.ram) {
            1
        } else if (laptop1.ram < laptop2.ram) {
            -1
        } else {
            0
        }
    }
}

class ComparatorYear: Comparator<Laptop> {
    override fun compare(laptop1: Laptop, laptop2: Laptop): Int {
        return if (laptop1.released > laptop2.released) {
            1
        } else if (laptop1.released < laptop2.released) {
            -1
        } else {
            0
        }
    }
}