class Customer(var totalPoints: Int = 0, var cashbackBalance: Int = 0, var spentPoints: Int = 0) {
    var status: String = "Bronze"

    init {
        updateStatus()
    }

    fun placeOrder(newUser: Boolean) {
        println("Enter the purchase amount:")
        val purchaseAmount = readLine()?.toIntOrNull() ?: 0

        val result = checkPrice(purchaseAmount, 0, status, newUser)
        totalPoints += result
        cashbackBalance += result
    }

    fun redeemPoints(pointsToRedeem: Int) {
        if (pointsToRedeem <= totalPoints) {
            totalPoints -= pointsToRedeem
            spentPoints += pointsToRedeem
            cashbackBalance -= pointsToRedeem / 2
            updateStatus()
            println("Redeemed $pointsToRedeem points successfully.")
            println("Remaining total points: $totalPoints")
            println("Spent points: $spentPoints")
            println("Updated cashback balance: $cashbackBalance")
            println("Customer status: $status")
        } else {
            println("Insufficient points to redeem.")
        }
    }

    private fun updateStatus() {
        when {
            spentPoints >= 20000 -> status = "Gold"
            spentPoints >= 10000 -> status = "Silver"
            else -> status = "Bronze"
        }
    }
}

fun main() {
    val customer = Customer()

    println("Welcome! Are you a new user? (true/false)")
    val newUserInput = readLine()?.toBoolean() ?: false

    customer.placeOrder(newUserInput)

    println("Do you want to redeem points? (true/false)")
    val redeemOption = readLine()?.toBoolean() ?: false

    if (redeemOption) {
        println("Enter the desired points to redeem:")
        val pointsToRedeem = readLine()?.toIntOrNull() ?: 0
        customer.redeemPoints(pointsToRedeem)
    }
}


fun calculateTotalPoints(previousPoints: Int, latestOrderCashback: Int): Int {
    return previousPoints + latestOrderCashback
}



fun checkPrice(price: Int, discount: Int, level: String, newUser: Boolean): Int {
    val totalPrice = price - discount

    val cashback = when (level) {
        "Gold" -> 20
        "Silver" -> 10
        "Bronze" -> 5
        else -> 0
    }

    val totalSum = 0 + totalPrice;

//

    val totalPointsForOrder = if (newUser) {
        totalPrice / 100 * cashback + 500
    } else {
        totalPrice / 100 * cashback
    }

    val totalPointsOfCustomer = 0 + totalPointsForOrder


    println("Сумма кешбека составит $totalPointsForOrder")
    println("Сумма заказа $totalPrice")

    return totalPointsForOrder

}
//добавить автоматазацию процесса получения статуса клиента, покупки на 5000 бронзовый, на 10к - серебро, на 20к золото
// добавлен стейдж