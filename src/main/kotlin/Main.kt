

fun main() {
val result = checkPrice(1000,5,"Silver",true)
}

fun checkPrice(price: Int, discount: Int, level: String, newUser: Boolean) {
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
    println("Сумма кешбека составит $totalPointsForOrder")
    println("Сумма заказа $totalPrice")


}
//добавить логику баланса кешбека пользователя
//добавить логику списания баллов пользователя
//добавить автоматазацию процесса получения статуса клиента, покупки на 5000 бронзовый, на 10к - серебро, на 20к золото
//