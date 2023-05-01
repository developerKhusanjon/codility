object CyclicRotation {

  def rotateAnArray(array: Array[Int], currentElem: Int, i: Int = 0): Array[Int] = {
    if (i >= array.length - 1) {
      val nextCurrentElem = array.apply(i)
      array.update(i, currentElem)
      array.update(0, nextCurrentElem)
      array
    }
    else {
      val nextCurrentElem = array.apply(i)
      array.update(i, currentElem)
      rotateAnArray(array, nextCurrentElem, i + 1)
    }
  }

  def rotateKTimes(a: Array[Int], k: Int, i: Int = 0): Array[Int] = {
    if (i >= k)
      a
    else rotateKTimes(rotateAnArray(a, a.apply(0)), k, i + 1)
  }

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.length > 0)
      rotateKTimes(a, k)
    else a
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(3, 8, 9, 7, 6), 3).mkString("Array(", ", ", ")"))
    println(solution(Array(), 3).mkString("Array(", ", ", ")"))
  }
}
