class Account(val accountName: String) {
    private var balance = 0
    private var transactions = mutableListOf<Int>()

    fun deposit(amount: Int) {
        if (amount > 0) {
            transactions.add(amount)
            balance += amount
            println("$amount deposited. Balance is now = $balance")
        } else {
            println("Cannot deposit negative sums.")
        }
    }

    fun withdraw(withdrawal: Int) {
        if (withdrawal in 1..balance) {
            transactions.add(withdrawal*-1)
            balance -= withdrawal
            println("$withdrawal withdrawed. Balance is now $balance")
        } else {
            println("Cannot withdraw that number.")
        }
    }

    fun calculateBalance(): Int {
        var tempBalance = 0
        for(transaction in transactions) {
            tempBalance += transaction
        }
        return tempBalance
    }
}