import kotlin.math.roundToInt

const val MASTER_CARD = "MasterCard"
const val MAESTRO = "Maestro"
const val MIR = "MIR"
const val VISA = "VISA"
const val VK_PAY = "VKPay"
const val FREE_COMMISSION = 0.00
const val COMMISSION_FROM_MASTER_AND_MAESTRO = 0.006
const val ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO = 20.00
const val COMMISSION_FROM_VISA_AND_MIR = 0.0075
const val MIN_TRANSFER_FOR_MASTER_AND_MAESTRO = 75_000.00
const val MIN_COMMISSION_FOR_VISA_AND_MIR = 35.00

fun main() {

    val amountTransfer = 85_101.00
    val outCommission = commissionFromPaymentSystem(amountTransfer, paymentSystem = MAESTRO)

    println("Сумма перевода: ${String.format("%.2f", amountTransfer)} руб.")
    println("Комиссия за перевод: ${String.format("%.2f", outCommission)} руб.")
}

fun commissionFromPaymentSystem(
    amountTransfer: Double,
    paymentSystem: String = VK_PAY,
    transferredAmount: Double = (0 + amountTransfer)
): Double {

    return when (paymentSystem) {

        MASTER_CARD -> if (amountTransfer < MIN_TRANSFER_FOR_MASTER_AND_MAESTRO) amountTransfer * FREE_COMMISSION
        else (amountTransfer * COMMISSION_FROM_MASTER_AND_MAESTRO) + ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO

        MAESTRO -> if (amountTransfer < MIN_TRANSFER_FOR_MASTER_AND_MAESTRO) amountTransfer * FREE_COMMISSION
        else (amountTransfer * COMMISSION_FROM_MASTER_AND_MAESTRO) + ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO

        MIR -> if (amountTransfer * COMMISSION_FROM_VISA_AND_MIR > MIN_COMMISSION_FOR_VISA_AND_MIR) amountTransfer * COMMISSION_FROM_VISA_AND_MIR
        else MIN_COMMISSION_FOR_VISA_AND_MIR

        VISA -> if (amountTransfer * COMMISSION_FROM_VISA_AND_MIR > MIN_COMMISSION_FOR_VISA_AND_MIR) amountTransfer * COMMISSION_FROM_VISA_AND_MIR
        else MIN_COMMISSION_FOR_VISA_AND_MIR

        else -> FREE_COMMISSION
    }
}