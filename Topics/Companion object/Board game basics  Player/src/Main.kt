class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        fun create(name: String): Player {
            val id = (0 .. Int.MAX_VALUE).random()
            return Player(id, name, 100)
        }
    }
}