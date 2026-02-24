data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val favorite: Boolean
)

fun formatContact(c: Contact): String {
    val phoneDisplay = c.phone ?: "N/A"
    val emailDisplay = c.email ?: "N/A"
    val star = if (c.favorite) "*" else ""
    return "${c.name} | Phone: $phoneDisplay | Email: $emailDisplay | $star"
}

fun filterContacts(
    contacts: List<Contact>,
    predicate: (Contact) -> Boolean
): List<Contact> {
    return contacts.filter(predicate)
}

fun printContacts(title: String, contacts: List<Contact>) {
    println("--- $title ---")
    contacts.forEachIndexed { index, c ->
        println("${index + 1}. ${formatContact(c)}")
    }
    println()
}

fun main() {
    val contacts = listOf(
        Contact("Maya Patel", "+91-90000-11111", "maya@example.com", true),
        Contact("Raj Sharma", null, "raj@sample.com", false),
        Contact("Li Wei", "+86-13800000000", null, false),
        Contact("Sara Ali", null, null, false),
        Contact("Tom O'Brien", "+1-555-1234", "tom@example.org", true)
    )

    printContacts("All Contacts", contacts)

    val favorites = filterContacts(contacts) { c -> c.favorite }
    printContacts("Favorite Contacts", favorites)

    val withEmail = filterContacts(contacts) { c -> c.email != null }
    printContacts("Contacts with Email", withEmail)
}
