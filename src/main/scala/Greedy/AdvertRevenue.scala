package Greedy
import scala.annotation.tailrec
import collection.mutable

object AdvertRevenue {

  def solve(revenue: Array[Int], slotAvClicks: Array[Int]): Int = {

    assert(revenue.length == slotAvClicks.length)
    val pairs = revenue.sorted.zip(slotAvClicks.sorted)
    pairs.foldLeft(0)((acc, pair) => acc + (pair._1 * pair._2))
  }

}
