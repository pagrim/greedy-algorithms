import scala.annotation.tailrec
import scala.io.StdIn.{readInt, readLine}

object MaxSalary {

  def getMaxSalary(initDigits: Array[Int]): Int = {

    @tailrec
    def _getMaxSalary(digits: Array[Int], answer: String): String = digits match {
      case Array() => answer
      case Array(_*) =>
        val digitsWithIdx = digits.zipWithIndex
        val maxDigitWithIdx = digitsWithIdx.foldLeft((0, -1))(
          (maxWithIdx, digWithIdx) =>
            if (digitLargest(digWithIdx._1, maxWithIdx._1) == maxWithIdx._1) maxWithIdx else digWithIdx)
        val newAnswer = answer + maxDigitWithIdx._1.toString
        val newDigits = digitsWithIdx.filter{
          digWithIdx => digWithIdx._2 != maxDigitWithIdx._2}.map{
          digWithIdx => digWithIdx._1}
        _getMaxSalary(newDigits, newAnswer)
    }
    _getMaxSalary(initDigits, "").toInt
  }


  def digitLargest(a: Int, b: Int): Int = {
    if(digitAppend(a, b) > digitAppend(b, a)) a else b
  }

  def digitAppend(a: Int, b: Int): Int = {
    (a.toString + b.toString).toInt
  }

  def main(args: Array[String]): Unit = {
    val arrLen = readInt()
    val input = readLine().split(" ").map( el => el.toInt)
    assert(arrLen == input.length)
    print(getMaxSalary(input))
  }
}
