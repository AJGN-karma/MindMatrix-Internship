// 1️⃣ Abstract class Animal
abstract class Animal(val name: String) {
    abstract fun makeSound()
}

// 3️⃣ Interface Feedable
interface Feedable {
    fun feed(food: String)
}

// 2️⃣ Subclass: Lion
class Lion(name: String) : Animal(name), Feedable {

    override fun makeSound() {
        println("$name: Roar!")
    }

    fun hunt() {
        println("$name is hunting in the jungle.")
    }

    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

// 2️⃣ Subclass: Elephant
class Elephant(name: String) : Animal(name) {

    override fun makeSound() {
        println("$name: Trumpet!")
    }

    fun sprayWater() {
        println("$name sprays water from its trunk.")
    }
}

// 2️⃣ Subclass: Parrot
class Parrot(name: String) : Animal(name) {

    override fun makeSound() {
        println("$name: Chirp!")
    }

    fun fly() {
        println("$name is flying around the zoo.")
    }
}

// 4️⃣ Function to display zoo animals
fun displayZoo(animals: List<Animal>) {
    println("--- Zoo Tracker ---")
    for (animal in animals) {
        animal.makeSound()   // Polymorphism in action
    }
}

// 5️⃣ Main function
fun main() {

    val lion = Lion("Lion")
    val elephant = Elephant("Elephant")
    val parrot = Parrot("Parrot")

    val zooAnimals: List<Animal> = listOf(lion, elephant, parrot)

    // Display all animals and their sounds
    displayZoo(zooAnimals)

    println()

    // Feeding animals (only Lion implements Feedable)
    lion.feed("meat")

    println()

    // Calling unique behaviors
    lion.hunt()
    elephant.sprayWater()
    parrot.fly()
}
