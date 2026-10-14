package com.example.tiptime

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Locale

class TipCalculatorTest {

    private lateinit var originalLocale: Locale

    @Before
    fun setUp() {
        originalLocale = Locale.getDefault()
        Locale.setDefault(Locale.US)
    }

    @After
    fun tearDown() {
        Locale.setDefault(originalLocale)
    }

    @Test
    fun calculateTip_20PercentNoRoundUp_returnsTenDollars() {
        val actualTip = calculateTip(
            amount = 50.0,
            tipPercent = 20.0,
            roundUp = false
        )

        assertEquals("\$10.00", actualTip)
    }

    @Test
    fun calculateTip_15Point5PercentRoundUp_returnsSixteenDollars() {
        val actualTip = calculateTip(
            amount = 100.0,
            tipPercent = 15.5,
            roundUp = true
        )

        assertEquals("\$16.00", actualTip)
    }

    @Test
    fun calculateTip_zeroAmount_returnsZeroDollars() {
        val actualTip = calculateTip(
            amount = 0.0,
            tipPercent = 15.0,
            roundUp = false
        )

        assertEquals("\$0.00", actualTip)
    }

    @Test
    fun calculateTip_defaultPercentage_returnsThirtyDollars() {
        val actualTip = calculateTip(
            amount = 200.0
        )

        assertEquals("\$30.00", actualTip)
    }
}