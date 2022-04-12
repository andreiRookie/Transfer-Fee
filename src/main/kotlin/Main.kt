const val TRANSFER_FEE = 0.0075
const val MINIMUM_TRANSFER_FEE_AMOUNT_IN_KOPECKS = 35_00U

fun main() {

    while (true) {
        print("Введите сумму(для выхода - 'end'): ")
        try {
            val input = readLine()
            if (input.equals("end", ignoreCase = true)) {
                println("Чао!")
                break
            }
            val amount = input?.toDouble() ?: return

            val transferFee = calculateTransferFee(amount)

            println("При сумме перевода $amount руб. комиссия составит: ${feeToString(transferFee)} руб.")

        } catch (e: NumberFormatException) {
            println("Неверный ввод")
        }
    }
}



fun calculateTransferFee(amount: Double): UInt {

    val amountInKopecks = (amount * 100)

    val transferFee = (amountInKopecks * TRANSFER_FEE).toUInt()

    val result = if (transferFee > MINIMUM_TRANSFER_FEE_AMOUNT_IN_KOPECKS ) transferFee else MINIMUM_TRANSFER_FEE_AMOUNT_IN_KOPECKS

    return result
}

fun feeToString(input: Any): String {

    val str = input.toString()

    return str.substring(0, (str.length - 2)) + "." + str.substring((str.length - 2), str.length)
}
