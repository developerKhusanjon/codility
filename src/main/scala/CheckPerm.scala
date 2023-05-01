object CheckPerm {

  def countNum(array: Array[Int], num: Int, count: Int = 0, i: Int = 0): Int = {
    if (i >= array.length)
      count
    else if (num == array.apply(i))
      countNum(array, num, count + 1, i + 1)
    else countNum(array, num, count, i + 1)
  }

  def checkPerm(a: Array[Int], index: Int = 1): Boolean = {
    if (index >= 100_000)
      countNum(a, index) == 1
    else if (index == a.length + 1)
      true
    else if (countNum(a, index) != 1)
      false
    else checkPerm(a, index + 1)
  }

  def solution(a: Array[Int]): Int = {
    if (a.length == 0)
      0
    else if (checkPerm(a))
      1
    else 0
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(4, 1, 3, 2)))
    println(solution(Array(4, 1, 2, 3)))
    println(solution(Array(4, 1, 3)))
    println(solution(Array(4, 1)))
    println(solution(Array(4)))
    println(solution(Array(0)))
    println(solution(Array()))
  }
}
