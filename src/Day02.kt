import kotlin.math.abs
//import java.util.*
//import java.io.*

fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0

        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() } // Split by single spaces and convert to integers
            var isSafe = true
            var isIncreasing: Boolean? = null // To determine if it's increasing or decreasing

            for (i in 0 until numbers.size - 1) {
                val diff = numbers[i] - numbers[i + 1]

                if (diff in -3..-1) { // Decreasing
                    if (isIncreasing == true) { // If it switches from increasing to decreasing
                        isSafe = false
                        break
                    }
                    isIncreasing = false
                } else if (diff in 1..3) { // Increasing
                    if (isIncreasing == false) { // If it switches from decreasing to increasing
                        isSafe = false
                        break
                    }
                    isIncreasing = true
                } else { // Invalid difference
                    isSafe = false
                    break
                }
            }

            //println("counter = $counter")
            if (isSafe) {
                counter++ // Increment only if the entire line is valid
            }
        }
        //println("counter = $counter")
        return counter
    }


    fun part2(input: List<String>): Int {
        var counter = 0

        for (line in input) {
            val numbers = line.split(" ").map { it.toInt() }

            for (i in numbers.indices) { // Iterate by index
                // Remove element at index i and check the list
                val nums = numbers.toMutableList()
                nums.removeAt(i)

                var isSafe = true
                var isIncreasing: Boolean? = null // To track whether it's increasing or decreasing

                for (j in 0 until nums.size - 1) {
                    val diff = nums[j] - nums[j + 1]

                    if (diff in -3..-1) { // Decreasing
                        if (isIncreasing == true) { // If the pattern switches from increasing to decreasing
                            isSafe = false
                            break
                        }
                        isIncreasing = false
                    } else if (diff in 1..3) { // Increasing
                        if (isIncreasing == false) { // If the pattern switches from decreasing to increasing
                            isSafe = false
                            break
                        }
                        isIncreasing = true
                    } else { // Invalid difference
                        isSafe = false
                        break
                    }
                }

                if (isSafe) {
                    counter++ // Increment if the condition is safe after removing the number
                    break // Exit the loop after finding the first valid configuration for this line
                }
            }
        }

        return counter
    }

    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the src/Day01_test.txt file:
    //var testInput = readInput("Day01_test")
    // 1 2
    // 2 3
    // 3 4
    //println("Test input: $testInput")
    //check(part1(testInput) == 2)

    //testInput = readInput("Day01_test")
    //check(part2(testInput) == 31)

    // Read the input from the src/Day01.txt file.
    val input = readInput("Day01")
    //part1(input).println()
    part2(input).println()


    // --------------------------
}