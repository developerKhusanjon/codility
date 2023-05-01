object OddOccureneElem {

  def containsElem(array: Array[Int], elem: Int, i: Int = 0): Boolean = {
    if (i >= array.length)
      false
    else if (elem == array.apply(i))
      true
    else containsElem(array, elem, i + 1)
  }

  def solution(a: Array[Int]): Int = {
    if (a.length <= 2)
      0
    else {
      var i = 0

      while (i < a.length - 1 && containsElem(a, a.apply(i))) {
        i = i + 1
      }

      a.apply(i)
    }
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(9, 3, 9, 3, 9, 7, 9)))
    println(solution(Array()))
    println(solution(Array(1)))
    println(solution(Array(1,2)))
  }
}
