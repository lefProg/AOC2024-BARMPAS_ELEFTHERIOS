import kotlin.math.abs


fun main() {
    fun part1(input: List<String>): Int {
        var lista1 = mutableListOf<Int>()
        var lista2 = mutableListOf<Int>()

        for (line in input) {
            val splitted = line.split("   ").map { it.toInt() }
            lista1.add(splitted[0])
            lista2.add(splitted[1])
        }

        // Now we have 2 lists of integers
        lista1.sort()
        lista2.sort()

        // 1,1,2,3,3,4
        // 1,2,2,3,3,4
        // 1

        var sum = 0
        for (i in 0..lista1.size - 1) {
            sum += abs(lista1[i] - lista2[i])
        }
        // for (i in lista1) {
        //     for (j in lista2) {
        //         sum += Math.abs(i - j)
        //     }
        // }

        return sum
    }

    fun part2(input: List<String>): Int {
        val rightlist = mutableListOf<Int>()
        val leftlist = mutableListOf<Int>()

        for (line in input) {
            val splitted = line.split("   ").map { it.toInt() }
            rightlist.add(splitted[0])
            leftlist.add(splitted[1])
        }

        var similarityCounter = 0

        for (n in leftlist) { // Iterate over values in leftlist
            var counter = 0
            for (m in rightlist) { // Iterate over values in rightlist
                if (m == n) {
                    counter += 1
                }
            }
            similarityCounter += n * counter
        }

        return similarityCounter
    }


    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the src/Day01_test.txt file:
    var testInput = readInput("Day01_test")
    // 1 2
    // 2 3
    // 3 4
    //println("Test input: $testInput")
    //check(part1(testInput) == 11)

    //testInput = readInput("Day01_test")
    check(part2(testInput) == 31)

    // Read the input from the src/Day01.txt file.
    val input = readInput("Day01")
    //part1(input).println()
    part2(input).println()


    // --------------------------
}
