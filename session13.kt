// -------------
// Student area
// -------------

// 1) Data class
data class Superhero(
    val name: String,
    val alias: String,
    val power: String,
    val favorite: Boolean = false,
    val accessibleDescription: String
)

// 2) Format hero (pure function)
fun formatHero(hero: Superhero): String {
    val favTag = if (hero.favorite) "[Fav]" else ""
    return "${hero.name} (${hero.alias}) - ${hero.power} $favTag (A11y: ${hero.accessibleDescription})"
}

// 3) Filter by power (case-insensitive contains)
fun filterByPower(heroes: List<Superhero>, powerQuery: String): List<Superhero> {
    val query = powerQuery.toLowerCase()
    return heroes.filter { hero ->
        hero.power.toLowerCase().contains(query)
    }
}

// 4) Get favorites
fun getFavorites(heroes: List<Superhero>): List<Superhero> {
    return heroes.filter { hero -> hero.favorite }
}

// 5) Generate schedule
fun generateSchedule(heroes: List<Superhero>, days: Int): List<String> {

    val favorites = getFavorites(heroes)
    val sourceList = if (favorites.isNotEmpty()) favorites else heroes

    val schedule = mutableListOf<String>()

    for (day in 0 until days) {
        val hero = sourceList[day % sourceList.size]
        schedule.add("Day ${day + 1}: ${hero.name} (${hero.alias})")
    }

    return schedule
}

// 6) Main function
fun main() {

    val heroes = listOf(
        Superhero(
            "Clark Kent",
            "Superman",
            "Flight",
            true,
            "Clark Kent, alias Superman, power Flight"
        ),
        Superhero(
            "Diana Prince",
            "Wonder Woman",
            "Strength",
            true,
            "Diana Prince, alias Wonder Woman, power Strength"
        ),
        Superhero(
            "Bruce Wayne",
            "Batman",
            "Intelligence",
            false,
            "Bruce Wayne, alias Batman, power Intelligence"
        ),
        Superhero(
            "Barry Allen",
            "Flash",
            "Speed",
            false,
            "Barry Allen, alias Flash, power Speed"
        ),
        Superhero(
            "Arthur Curry",
            "Aquaman",
            "Water Control",
            false,
            "Arthur Curry, alias Aquaman, power Water Control"
        ),
        Superhero(
            "Hal Jordan",
            "Green Lantern",
            "Energy Constructs",
            false,
            "Hal Jordan, alias Green Lantern, power Energy Constructs"
        )
    )

    // --- Superhero Directory ---
    println("--- Superhero Directory ---")
    for ((index, hero) in heroes.withIndex()) {
        println("${index + 1}. ${formatHero(hero)}")
    }

    // --- Filter by power ---
    val filtered = filterByPower(heroes, "flight")
    println("\n--- Filter: flight ---")
    for ((index, hero) in filtered.withIndex()) {
        println("${index + 1}. ${formatHero(hero)}")
    }

    // --- Favorites ---
    val favorites = getFavorites(heroes)
    println("\n--- Favorites ---")
    for ((index, hero) in favorites.withIndex()) {
        println("${index + 1}. ${formatHero(hero)}")
    }

    // --- 30-Day Schedule ---
    val schedule = generateSchedule(heroes, 30)
    println("\n--- 30-Day Schedule ---")
    for (entry in schedule) {
        println(entry)
    }
}
