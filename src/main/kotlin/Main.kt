
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
            println("Списано $pointsToRedeem баллов.")
            println("Оставшееся количество баллов: $totalPoints")
            println("Spent points: $spentPoints")
            println("Ваш баланс: $cashbackBalance")
            println("Статус участника программы лояльности $status")
        } else {
            println("Некорректное количество баллов.")
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

    println("Вы новый пользователь? (true/false)")
    val newUserInput = readLine()?.toBoolean() ?: false

    customer.placeOrder(newUserInput)

    println("Вы хотите списать баллы? (true/false)")
    val redeemOption = readLine()?.toBoolean() ?: false

    if (redeemOption) {
        println("Enter the desired points to redeem:")
        val pointsToRedeem = readLine()?.toIntOrNull() ?: 0
        customer.redeemPoints(pointsToRedeem)
    }
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



    println("Сумма кешбека составит $totalPointsForOrder")
    println("Сумма заказа $totalPrice")

    return totalPointsForOrder

}

class Seller(var card: Boolean = true, var cash: Boolean = true) {

    fun canPayByCard() {
        if (card) {
            println("Доступна оплата по терминалу")
        } else {
            println("Оплата по терминалу недоступна")
        }
    }
    var canUseCard = canPayByCard()
}
