object TapeEquilibrium {

  def sumElems(array: Array[Int], sum: Int = 0, start: Int, end: Int): Int = {
    if (start >= end - 1)
      sum + array.apply(start)
    else sumElems(array, sum + array.apply(start), start + 1, end)
  }

  def calculateDifference(a: Array[Int], p: Int): Int = {
    val part1 = sumElems(a, start = 0, end = p)
    val part2 = sumElems(a, start = p, end = a.length)

    if (part1 > part2)
      part1 - part2
    else part2 - part1
  }

  def findMinDiff(a: Array[Int], index: Int = 1, min: Int): Int = {
    val diff = calculateDifference(a, index)
    if (index >= a.length - 1) {
      if (min < diff)
        min
      else diff
    } else if (diff < min) findMinDiff(a, index + 1, diff) else findMinDiff(a, index + 1, min)

  }

  def solution(a: Array[Int]): Int = {
    if (a.length > 2)
      findMinDiff(a, min = calculateDifference(a, 0))
    else if (a.length == 2) {
      if (a.apply(0) > a.apply(1))
        a.apply(0) - a.apply(1)
      else a.apply(1) - a.apply(0)
    } else if (a.length == 1) a.apply(0) else 0
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(3, 1, 2, 4, 3)))
    println(solution(Array(3)))
    println(solution(Array(3, 1)))
    println(solution(Array(3, 1, 4)))
    println(solution(Array()))
  }
}
