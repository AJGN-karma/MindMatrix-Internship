import kotlin.random.Random

// Function to roll a single die
fun rollDie(sides: Int, rnd: Random): Int {
    return rnd.nextInt(1, sides + 1)
}

// Function to roll two six-sided dice
fun rollTwoDice(rnd: Random): Pair<Int, Int> {
    val a = rollDie(6, rnd)
    val b = rollDie(6, rnd)
    return Pair(a, b)
}

// Function to format the roll output
fun formatRoll(rollNumber: Int, a: Int, b: Int): String {
    val base = "Roll $rollNumber: $a and $b"
    return if (a == b) "$base -> Double!" else base
}

// Main function
fun main() {
    println("--- Dice Roller ---")
    val rnd = Random(123) // Seed for reproducible output
    var rollNumber = 0

    repeat(3) {
        rollNumber++
        println("Pressing 'Roll'...")
        val (a, b) = rollTwoDice(rnd)
        println(formatRoll(rollNumber, a, b))
    }
}
