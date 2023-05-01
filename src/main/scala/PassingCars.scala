object PassingCars {

  def countPairs(array: Array[Int], start: Int = 1, sum: Int = 0): Int = {
    if (start >= array.length)
      sum
    else if (array(start) == 1)
      countPairs(array, start + 1, sum + 1)
    else countPairs(array, start + 1, sum)
  }

  def countSum(array: Array[Int], i: Int = 0, sum: Int = 0): Int = {
    if (i >= array.length - 1)
      sum
    else if (array(i) == 0)
      countSum(array, i + 1, sum + countPairs(array, i + 1))
    else countSum(array, i + 1, sum)
  }

  def solution(a: Array[Int]): Int = {
    countSum(a)
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(0, 1, 0, 1, 1)))
  }
}
