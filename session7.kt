import java.util.Locale
import kotlin.math.ceil

// Function to calculate the tip
fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {
    val tip = amount * tipPercent / 100.0
    return if (roundUp) ceil(tip) else tip
}

// Function to format an amount with two decimal places
fun formatAmount(amount: Double): String {
    return String.format(Locale.US, "%.2f", amount)
}

// Main function with sample scenarios
fun main() {
    val scenarios = listOf(
        Triple(50.00, 15, false),
        Triple(75.20, 18, true),
        Triple(100.00, 20, false)
    )

    for ((amount, tipPercent, roundUp) in scenarios) {
        val tip = calculateTip(amount, tipPercent, roundUp)
        println(
            "Bill: ${formatAmount(amount)} | Tip percent: $tipPercent% | " +
            "Round up: $roundUp | Tip: ${formatAmount(tip)}"
        )
    }
}
