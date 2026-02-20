// =========================================================
// KOTLIN PROJECT LAB
// Topic: Simulating Your First Android App in Kotlin
// Duration: ~40–50 minutes
// =========================================================
//
// Overview:
// This simulates an Android "Greeting Card" app using plain Kotlin.
// Structure mirrors Jetpack Compose: MainActivity -> setContent -> GreetingScreen -> Preview
// =========================================================

@Target(AnnotationTarget.FUNCTION)
annotation class Composable

// Simulating the MainActivity structure
class MainActivity {

    fun onCreate() {
        println("Launching Greeting Card Simulation...")

        // TODO 1: Call the setContent() function and pass a lambda that calls GreetingScreen("YourName")
        // Wrapped inside AppTheme for styling
        setContent {
            AppTheme {
                GreetingScreen("Jeevan")  // Replace with your name
            }
        }
    }

    // Simulated setContent() method
    private fun setContent(content: () -> Unit) {
        println("Setting up the content...")
        content()
    }
}

// TODO 2: GreetingScreen composable
@Composable
fun GreetingScreen(name: String) {
    println("Hello $name! Welcome to your first Kotlin App!")
}

// TODO 3: AppTheme composable
@Composable
fun AppTheme(content: () -> Unit) {
    println("Applying GreetingCard Theme...")
    content()
}

// Simulated Preview function
fun Preview() {
    println("---- Preview Mode ----")
    AppTheme {
        GreetingScreen("PreviewUser")
    }
}

// Entry point
fun main() {
    val activity = MainActivity()
    activity.onCreate()

    // Run preview
    Preview()
}
