package test_zalando

object Task1 {
  def solution(A: Array[Int], X: Int): Int = {
    var N: Int = A.length;
    if (N == 0) -1
    else {
      var l: Int = 0;
      var r: Int = N - 1;
      while (l < r) {
        var m: Int = (l + r) / 2;
        if (A(m) > X) {
          r = m - 1;
        } else {
          l = m;
        }
      }
      if (A(l) == X) {
        l
      } else -1
    }
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1, 2), 2))
  }
}
