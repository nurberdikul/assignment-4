package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Locale

class TipCalculatorTest {

    @Test
    fun calculateTip_20PercentNoRoundUp_returnsTenDollars() {
        Locale.setDefault(Locale.US)

        val actualTip = calculateTip(
            amount = 50.0,
            tipPercent = 20.0,
            roundUp = false
        )

        assertEquals("\$10.00", actualTip)
    }

    @Test
    fun calculateTip_15Point5PercentRoundUp_returnsSixteenDollars() {
        Locale.setDefault(Locale.US)

        val actualTip = calculateTip(
            amount = 100.0,
            tipPercent = 15.5,
            roundUp = true
        )

        assertEquals("\$16.00", actualTip)
    }

    @Test
    fun calculateTip_zeroAmount_returnsZeroDollars() {
        Locale.setDefault(Locale.US)

        val actualTip = calculateTip(
            amount = 0.0,
            tipPercent = 15.0,
            roundUp = false
        )

        assertEquals("\$0.00", actualTip)
    }
}