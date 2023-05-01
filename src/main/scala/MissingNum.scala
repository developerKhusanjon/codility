import scala.collection.JavaConverters._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object MissingNum {

  /*
  This is a demo task.

  Write a function:

      object Solution { def solution(a: Array[Int]): Int }

  that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

  For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

  Given A = [1, 2, 3], the function should return 4.

  Given A = [−1, −3], the function should return 1.

  Write an efficient algorithm for the following assumptions:

          N is an integer within the range [1..100,000];
          each element of array A is an integer within the range [−1,000,000..1,000,000].


   */

  def solutionMin(a: Array[Int], i: Int = 0, min: Int = 1): Int = {
    // Implement your solution here
    if (i >= a.length)
      min
    else if (!containsNum(a, 0, min))
      min
    else solutionMin(a, i + 1, min + 1)
  }

  def containsNum(a: Array[Int], i: Int = 0, num: Int): Boolean = {
    if (i >= a.length)
      false
    else if (a.apply(i) == num)
      true
    else containsNum(a, i + 1, num)
  }

  def solution(a: Array[Int]): Int = {
    solutionMin(a)
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array[Int](1, 3, 6, 4, 1, 2)))
    println(solution(Array[Int](1, 2, 3)))
    println(solution(Array.apply(-1, -3)))
  }
}
