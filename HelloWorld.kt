fun main() {

    println("========== Kotlin Kickstart: Session Progress Report ==========\n")

    // -----------------------------------------------------
    // PART 1: Introducing Yourself
    // -----------------------------------------------------
    val userName = "Jeevan"
    println("Hello, I'm $userName, and this is my Kotlin learning report for today.\n")

    // -----------------------------------------------------
    // PART 2: Sharing Your Practice Stats (val vs var)
    // -----------------------------------------------------
    val initialScore = 10
    var currentScore = 10
    currentScore += 15
    println("My initial goal score was $initialScore, but now I've reached $currentScore points!\n")

    // -----------------------------------------------------
    // PART 3: Reporting Learning Progress (Functions)
    // -----------------------------------------------------
    val totalProgress = calculateProgress(30, 20)
    println("In total, I've earned $totalProgress learning points today.\n")

    // -----------------------------------------------------
    // PART 4: Listing Topics You Explored
    // -----------------------------------------------------
    val topics = mutableListOf("Variables", "Functions", "Strings")
    topics.add("Loops")
    topics.removeAt(2) // removes "Strings"
    println("Today, I explored the following topics: ${summarizeTopics(topics)}\n")

    // -----------------------------------------------------
    // PART 5 (Optional Challenge – Reflective Summary)
    // -----------------------------------------------------
    encourageUser(userName, topics)

    println("\n========== End of My Kotlin Learning Report ==========")
}

// =========================================================
// FUNCTION SECTION – define your functions below main()
// =========================================================

fun calculateProgress(base: Int, bonus: Int): Int {
    return base + bonus
}

fun summarizeTopics(topics: List<String>): String {
    return topics.joinToString(", ")
}

fun encourageUser(name: String, topics: List<String>) {
    println("I'm proud of myself! I, $name, completed ${topics.size} topics in this session.")
}
