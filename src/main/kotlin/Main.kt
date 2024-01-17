

fun main() {
val result = checkPrice(1000,5,"Silver",true)
}

fun checkPrice(price: Int, discount: Int, level: String, newUser: Boolean) {
    var totalPrice = price - discount

    var cashback = when (level) {
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

