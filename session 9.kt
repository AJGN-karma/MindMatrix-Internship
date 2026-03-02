// ----------------------
// Inventory Manager with Generics
// ----------------------

// 1) Data class
data class Item(
    val name: String,
    val category: String,
    val quantity: Int
)

// 2) Function to print inventory
fun printInventory(items: List<Item>) {
    if (items.isEmpty()) {
        println("No items found.")
        return
    }

    for (item in items) {
        println("Name: ${item.name} | Category: ${item.category} | Qty: ${item.quantity}")
    }
}

// 3) Generic filter function
fun <T> filterList(list: List<T>, condition: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (element in list) {
        if (condition(element)) {
            result.add(element)
        }
    }
    return result
}

// 4) Main function
fun main() {

    // Sample inventory items
    val inventory = listOf(
        Item("Laptop", "Electronics", 12),
        Item("Keyboard", "Electronics", 5),
        Item("Chair", "Furniture", 20),
        Item("Table", "Furniture", 8),
        Item("Notebook", "Stationery", 50),
        Item("Pen", "Stationery", 7)
    )

    // --- Full Inventory ---
    println("--- Full Inventory ---")
    printInventory(inventory)

    // --- Low Stock (<10) ---
    val lowStock = filterList(inventory) { item ->
        item.quantity < 10
    }

    println("\n--- Low Stock (<10) ---")
    printInventory(lowStock)

    // --- Electronics Category ---
    val electronicsItems = filterList(inventory) { item ->
        item.category == "Electronics"
    }

    println("\n--- Electronics Category ---")
    printInventory(electronicsItems)

    // --- Total Quantity per Category ---
    println("\n--- Total Quantity per Category ---")

    val totalPerCategory = inventory
        .groupBy { it.category }
        .mapValues { entry ->
            entry.value.map { it.quantity }.sum()
        }

    for ((category, total) in totalPerCategory) {
        println("$category: $total")
    }
}
