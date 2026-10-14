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
}