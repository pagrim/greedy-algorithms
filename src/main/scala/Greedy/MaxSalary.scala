package Greedy

import scala.annotation.tailrec

object MaxSalary {

  def getMaxSalary(initDigits: Array[Int]): String = {

    @tailrec
    def _getMaxSalary(digits: Array[Int], answer: String): String = digits match {
      case Array() => answer
      case Array(_*) =>
        val maxDigit = digits.foldLeft(Int.MinValue)( (dig, max) => digitLargest(dig, max))
        val newAnswer = answer + maxDigit.toString
        val newDigits = digits.drop(maxDigit)
        _getMaxSalary(newDigits, newAnswer)
    }
    _getMaxSalary(initDigits, "")
  }


  def digitLargest(a: Int, b: Int): Int = {
    if(digitAppend(a, b) > digitAppend(b, a)) a else b
  }

  def digitAppend(a: Int, b: Int): Int = {
    (a.toString + b.toString).toInt
  }
}
