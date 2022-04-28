import org.junit.Test

import org.junit.Assert.*

@Suppress("DEPRECATION")
class MainKtTest {


    @Test
    fun commissionFromPaymentSystemMASTERCARD() {
        // arrange

        val amount = 76_000.0
        val system = MASTER_CARD
        val transferred = (0.00 + amount)
        val expected = 500

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }

    @Test
    fun commissionFromPaymentSystemMAESTRO() {
        // arrange

        val amount = 85_101.0
        val system = MAESTRO
        val transferred = (0.00 + amount)
        val expected = 530

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }


    @Test
    fun commissionFromPaymentSystemMIR() {
        // arrange

        val amount = 85_101.0
        val system = MIR
        val transferred = (0.00 + amount)
        val expected = 600

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }

    @Test
    fun commissionFromPaymentSystemMIRmin() {
        // arrange

        val amount = 120.0
        val system = MIR
        val transferred = (0.00 + amount)
        val expected = 35

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }


    @Test
    fun commissionFromPaymentSystemVISA() {
        // arrange

        val amount = 16_100.0
        val system = VISA
        val transferred = (0.00 + amount)
        val expected = 120

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }


    @Test
    fun commissionFromPaymentSystemVISAmin() {
        // arrange

        val amount = 100.0
        val system = VISA
        val transferred = (0.00 + amount)
        val expected = 35

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }

    @Test
    fun commissionFromPaymentSystemVKPAY() {
        // arrange

        val amount = 7_500.0
        val system = VK_PAY
        val transferred = (0.00 + amount)
        val expected = 0

        // act

        val result = commissionFromPaymentSystem(
            amountTransfer = amount,
            paymentSystem = system,
            transferredAmount = transferred
        )

        // assert

        assertEquals(expected, result.toInt())
    }
}