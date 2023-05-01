object Main {
  def main(args: Array[String]): Unit = {


    val c = collection.mutable.Buffer("T")
    c+="h"
    println(c)

    val m = Map("x" -> "a", "x" -> "b")
    println(m("x"))

    "milan" ensuring (_.length > 3)
  }
}