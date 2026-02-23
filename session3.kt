// -----------------
// Student area
// -----------------

// 1) Define data class Profile
data class Profile(val name: String, val title: String, val bio: String)

// 2) Render avatar placeholder
fun renderAvatar(width: Int, height: Int): String {
    val lines = mutableListOf<String>()
    val placeholder = "[Avatar ${width}x${height}]"
    val paddingLeft = 1
    val paddingRight = width - placeholder.length - paddingLeft - 1
    lines.add("| " + placeholder + " ".repeat(paddingRight) + "|")
    for (i in 1 until height) {
        lines.add("|" + " ".repeat(width - 2) + "|")
    }
    return lines.joinToString("\n")
}

// 3) Render text block
fun renderTextBlock(label: String, text: String, width: Int): String {
    val maxTextLength = width - label.length - 6 // account for " | " and padding
    val trimmedText = if (text.length > maxTextLength) text.take(maxTextLength) else text
    val line = "| $label: $trimmedText"
    val padding = width - line.length - 1
    return line + " ".repeat(padding) + "|"
}

// 4) Render profile card
fun renderProfile(profile: Profile, width: Int = 24, showAvatar: Boolean = true): String {
    val border = "+${"-".repeat(width - 2)}+"
    val lines = mutableListOf<String>()
    lines.add(border)
    if (showAvatar) {
        lines.add(renderAvatar(width, 2))
    }
    lines.add(renderTextBlock("Name", profile.name, width))
    lines.add(renderTextBlock("Title", profile.title, width))
    lines.add(renderTextBlock("Bio", profile.bio, width))
    lines.add(border)
    return lines.joinToString("\n")
}

// 5) Main function
fun main() {
    val p1 = Profile("Ada Lovelace", "Software Dev", "Early computing pioneer")
    val p2 = Profile("Alan Turing", "Mathematician", "Father of computer science")
    val p3 = Profile("Grace Hopper", "Rear Admiral", "Inventor of COBOL")

    println(renderProfile(p1, 24, showAvatar = true))
    println()
    println(renderProfile(p2, 24, showAvatar = false))
    println()
    println(renderProfile(p3, 24, showAvatar = true))
}
