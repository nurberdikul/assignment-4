package com.example.tiptime

import java.text.NumberFormat
import kotlin.math.ceil

fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean = false
): String {
    var tip = tipPercent / 100 * amount

    if (roundUp) {
        tip = ceil(tip)
    }

    return NumberFormat.getCurrencyInstance().format(tip)
}