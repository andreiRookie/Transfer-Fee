import org.junit.Test

import org.junit.Assert.*
import kotlin.math.exp

class MainKtTest {

    @Test
    fun calculateTransferFeeTest_shouldBeMinimumTransferFee() {

        //arrange
        val amount = 1000.00
        val expectedFee = 35_00U

        //act
        val actualFee = calculateTransferFee(amount)

        //assert
        assertEquals(expectedFee, actualFee)
    }

    @Test
    fun calculateTransferFeeTest_shouldBeMoreThanMinimumTransferFee() {

        //arrange
        val amount = 10000.00
        val expectedFee = 75_00U

        //act
        val actualFee = calculateTransferFee(amount)

        //assert
        assertEquals(expectedFee, actualFee)
    }

    @Test
    fun feeToStringTest() {

        val input = 12345678U
        val expectedString = "123456.78"

        val actualString = feeToString(input)

        assertEquals(expectedString, actualString)
    }
}