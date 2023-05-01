package test_zalando

object Task2 {

  def findHighest(array: Array[Int], i: Int = 0, highest: Int = 0): Int = {
    if (i >= array.length)
      highest
    else if (array(i) > highest)
      findHighest(array, i + 1, array(i))
    else findHighest(array, i + 1, highest)
  }


  def countStrokes(array: Array[Int], height: Int = 1, strokes: Int = 0, index: Int = 0, painted: Boolean = false): Int = {
    if (index >= array.length)
      strokes
    else if (array(index) >= height) {
      if (!painted) countStrokes(array, height, strokes + 1, index + 1, painted = true)
      else countStrokes(array, height, strokes, index + 1, painted = true)
    } else countStrokes(array, height, strokes, index + 1, painted = false)
  }

  def sumStrokes(array: Array[Int], height: Int = 1, highest: Int, sum: Int = 0): Int = {
    if (sum > 1000000000)
      -1
    else if (height >= highest)
      sum + countStrokes(array, height)
    else sumStrokes(array, height + 1, highest, sum + countStrokes(array, height))
  }

  def solution(a: Array[Int]): Int = {
    sumStrokes(a, highest = findHighest(a))
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2, 1000000000)))
    println(solution(Array(1, 3, 2, 1)))
    println(solution(Array(5, 6)))
    println(solution(Array(5, 8)))
    println(solution(Array(8, 5)))
    println(solution(Array(1, 1, 1, 1)))
    println(solution(Array()))
  }

}
