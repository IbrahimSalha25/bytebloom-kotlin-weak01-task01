package org.example

// 05-07-2026 - ibrahim salha - ibrahimsalha19@gmail.com

fun main() {

    // Problem 1 (Priority Dispatcher): Write a loop from 1 to 50 representing package indices.
    // Print 'Express' for multiples of 3,
    // 'Freight' for multiples of 5,
    // 'PriorityExpress' for both,
    // otherwise print the index.

    println("-*-*-*-* Problem 01  *-*-*-*-")

    for (packageIndex in 1..50) {
        when {
            packageIndex % 3 == 0 && packageIndex % 5 == 0 -> println("PriorityExpress")
            packageIndex % 3 == 0 -> println("Express")
            packageIndex % 5 == 0 -> println("Freight")
            else -> println(packageIndex)
        }
    }

    // Problem 2 (Waypoints Reverser): Reverse a flat route format
    // 'HubA HubB HubC' to 'HubC HubB HubA' without built-in reversal functions.

    println("-*-*-*-* Problem 02  *-*-*-*-")

    val waypoints = arrayOf("HubA", "HubB", "HubC")

    for (index in waypoints.size - 1 downTo 0) {
        print("${waypoints[index]} ")
    }
    println("")

    // Problem 3 (Max Weight Filter): Identify the highest valid package weight
    // in a decimal array containing positive numbers and invalid -1.0 tags.
    // Avoid helper sorting functions.

    println("-*-*-*-* Problem 03  *-*-*-*-")

    val weights = doubleArrayOf(12.5, -1.0, 8.3, 20.0, -1.0, 15.2)
    var maxWeight = weights[0]

    for (weight in weights) {
        if (weight != -1.0 && weight > maxWeight) {
            maxWeight = weight
        }
    }
    println("Max valid weight: $maxWeight")

    // Problem 4 (Palindrome Transit Code): Write a case-insensitive check to determine
    // if transit codes like 'TR808RT' are palindromes.

    println("-*-*-*-* Problem 04 *-*-*-*-")

    val code01 = "TR808RT"
    println("TR808RT :  ${isPalindrome(code01)}")

    val code02 = "TR808rt"
    println("TR808rt :  ${isPalindrome(code02)}")

    val code03 = "Td808RT"
    println("Td808RT :  ${isPalindrome(code03)}")


    // Problem 5 (Binary Search Lookup): Write a manual Binary Search function
    // to find a tracking ID index in a sorted IntArray,
    // printing the search steps and estimating the Big O notation.

    println("-*-*-*-* Problem 05  *-*-*-*-")

    val ids = intArrayOf(2, 63, 500 ,64,59,525,525, 12, 64, 23, 38)
    binarySearch(ids, 64)

    println("Time Complexity: O(log n)")
}

fun isPalindrome(code: String): Boolean {
    val normalized = code.lowercase()

    var left = 0
    var right = normalized.length - 1

    while (left < right) {
        if (normalized[left] != normalized[right]) {
            return false
        }
        left++
        right--
    }
    return true
}

fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1
    var step = 1

    while (left <= right) {
        val mid = (left + right) / 2

        println("Step $step: left=$left, right=$right, mid=$mid")

        when {
            arr[mid] == target -> {
                println("Found at index $mid")
                return mid
            }
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }

        step++
    }

    println("Not found")
    return -1
}