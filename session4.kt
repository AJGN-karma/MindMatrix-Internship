// Step 1: Define BusinessCard data class
data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String
)

// Step 2: Utility function to center text
fun centerText(text: String, width: Int): String {
    val padding = (width - text.length) / 2
    return " ".repeat(padding.coerceAtLeast(0)) + text
}

// Step 3: Print Logo
fun printLogo(width: Int) {
    println("|${centerText("[ANDROID]", width - 2)}|")
}

// Step 4: Print Header (Name + Title)
fun printHeader(card: BusinessCard, width: Int) {
    println("|${centerText(card.name, width - 2)}|")
    println("|${centerText(card.title, width - 2)}|")
}

// Step 5: Print Contacts (conditionally)
fun printContacts(card: BusinessCard, width: Int, showContacts: Boolean) {
    if (showContacts) {
        println("|  Phone: ${card.phone}${" ".repeat(width - 2 - ("  Phone: ${card.phone}").length)}|")
        println("|  Email: ${card.email}${" ".repeat(width - 2 - ("  Email: ${card.email}").length)}|")
    }
}

// Step 6: Main function
fun main() {
    val width = 50
    val card = BusinessCard(
        name = "Aditya Deshpande",
        title = "Android Developer",
        phone = "+91-98765-43210",
        email = "ajgn232232@gmail.com"
    )

    println("-".repeat(width))
    printLogo(width)
    println("|${" ".repeat(width - 2)}|") // Empty line
    printHeader(card, width)
    println("|${" ".repeat(width - 2)}|") // Empty line
    printContacts(card, width, showContacts = true)
    println("-".repeat(width))
}
