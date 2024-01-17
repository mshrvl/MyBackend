class Customer(var totalPoints: Int = 0) {
    fun placeOrder(price: Int, discount: Int, level: String, newUser: Boolean) {
    val orderCashback = checkPrice(price, discount, level, newUser)
    totalPoints += orderCashback
    println("Total points for the customer: $totalPoints")
}
}
private fun main() {
val result = checkPrice(1000,5,"Silver",false)
    val totalPoints = calculateTotalPoints(90,50)
    println("Сумма ваших баллов:" + totalPoints)

    val customer = Customer(0)

    customer.placeOrder(1000,5,"Silver", true)
    customer.placeOrder(699,5,"Silver", false)


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

    val totalPointsForOrder = if(newUser) {
        totalPrice / 100 * cashback + 500
    } else {
        totalPrice / 100 * cashback
    }

    val totalPointsOfCustomer = 0 + totalPointsForOrder


    println("Сумма кешбека составит $totalPointsForOrder")
    println("Сумма заказа $totalPrice")

    return totalPointsForOrder


}

//добавить логику баланса кешбека пользователя
//добавить логику списания баллов пользователя
//добавить автоматазацию процесса получения статуса клиента, покупки на 5000 бронзовый, на 10к - серебро, на 20к золото
// добавлен стейдж