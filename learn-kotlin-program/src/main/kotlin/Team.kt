class Team<T>(val name: String, val players: MutableList<T>) {
    fun addPlayer(player: T) {
        if (players.contains(player)) {
            println("Player: ${(player as Player).name} is existed in this ${this.name} team.")
        } else {
            players.add(player)
            println("Player: ${(player as Player).name} is added to this ${this.name} team.")
        }
    }
}

// to create an upper bound using
// class Team<T: Player>
// => then we can add footballPlayer to Team<BaseballPlayer> and vice versa.