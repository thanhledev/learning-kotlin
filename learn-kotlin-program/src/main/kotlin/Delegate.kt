import kotlin.reflect.KProperty

class Delegate {
    private var value: String = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("${property.name} is read.")
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("${property.name} is written.")
        this.value = value
    }
}