// implement primary constructor and methods
class Box<T>(private val furniture: T, private val volume: Int) {
    fun getBoxVolume(): Int {
        return volume
    }
    fun getFurnitureFromBox(): T {
        return furniture
    }
}

// Don't change classes below
class Fridge
class Armchair