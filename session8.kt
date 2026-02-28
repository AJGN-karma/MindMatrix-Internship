// Data class for Artwork
data class Artwork(val title: String, val artist: String, val year: Int)

// Function to display artwork details
fun displayArtwork(art: Artwork) {
    println("Viewing: ${art.title} (${art.artist}, ${art.year})")
}

// Function to get next artwork index (wrap to 0 if at end)
fun nextArtwork(currentIndex: Int, total: Int): Int {
    return (currentIndex + 1) % total
}

// Function to get previous artwork index (wrap to last if at start)
fun previousArtwork(currentIndex: Int, total: Int): Int {
    return if (currentIndex - 1 < 0) total - 1 else currentIndex - 1
}

// Main function to simulate navigation
fun main() {
    val artworks = listOf(
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("The Persistence of Memory", "Salvador Dali", 1931),
        Artwork("The Scream", "Edvard Munch", 1893)
    )

    var currentIndex = 0
    displayArtwork(artworks[currentIndex])

    println("-> Next Artwork")
    currentIndex = nextArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])

    println("-> Next Artwork")
    currentIndex = nextArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])

    println("-> Next Artwork")
    currentIndex = nextArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])

    println("-> Previous Artwork")
    currentIndex = previousArtwork(currentIndex, artworks.size)
    displayArtwork(artworks[currentIndex])
}
