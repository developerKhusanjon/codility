package test_zalando

object Task3 {

  def countNum(a: Array[String], num: String, i: Int = 0, sum: Int = 0): Int = {
    if (i >= a.length)
      sum
    else if (a(i).contains(num))
      countNum(a, num, i + 1, sum + 1)
    else countNum(a, num, i + 1, sum)
  }

  def countBoth(a: Array[String], num1: String, num2: String, i: Int = 0, sum: Int = 0): Int = {
    if (num1.equals(num2))
      0
    else if (i >= a.length)
      sum
    else if (a(i).contains(num1) && a(i).contains(num2))
      countBoth(a, num1, num2,  i + 1, sum + 1)
    else countBoth(a, num1, num2,  i + 1, sum)
  }

  def sumMaxCounts(a: Array[String], day: Int = 0, max: Int = 0, oMax: Int = 0, maxDay: Int = 0, oMaxDay: Int = -1): Int = {
    if (day >= 10) {
      max + oMax - countBoth(a, maxDay.toString, oMaxDay.toString)
    } else {
      val count = countNum(a, day.toString)
      if (count > max)
        sumMaxCounts(a, day + 1, count, max, maxDay = day, oMaxDay = maxDay)
      else if (count > oMax)
        sumMaxCounts(a, day + 1, max, count, maxDay, oMaxDay = day)
      else sumMaxCounts(a, day + 1, max, oMax, maxDay, oMaxDay)
    }
  }

  def solution(e: Array[String]): Int = {
    sumMaxCounts(e)
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array("")))
  }
}
