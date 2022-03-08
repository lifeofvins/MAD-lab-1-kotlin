class BankAccount {
    var balance: Long = 0
        get() {
            if (!this.isOpened) throw IllegalStateException()
            else return field

        }
        set(value) {
            if (!this.isOpened) throw IllegalStateException()
            field = value

        }

    var isOpened: Boolean = true

    fun adjustBalance(amount: Long) {
        synchronized(this) {
            if (amount < 0 && (this.balance + amount) < 0)
                throw IllegalStateException()
            if (!this.isOpened)
                throw IllegalStateException()
            this.balance += amount
        }
    }

    fun close() {
        synchronized(this) {
            if (!this.isOpened)
                throw IllegalStateException()
            this.isOpened = false
        }
    }
}
