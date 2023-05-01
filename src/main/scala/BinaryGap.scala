object BinaryGap {

  def calculateGap(n: Int, gap: Int = 0, max: Int = 0): Int = {
    if (n < 1)
      max
    else if (n % 2 == 1) {
      if (gap > max)
        calculateGap(n / 2, 0, gap)
      else calculateGap(n / 2, 0, max)
    } else calculateGap(n / 2, gap + 1, max)
  }

  def solution(n: Int): Int = {
    if (n % 2 == 1)
      calculateGap(n)
    else solution(n / 2)
  }

  def main(args: Array[String]): Unit = {
    println(solution(9))
    println(solution(529))
    println(solution(4))
    println(solution(20))
    println(solution(32))
  }
}
