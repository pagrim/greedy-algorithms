import scala.io.StdIn.{readInt, readLine}

object AdvertRevenue {

  def solve(revenue: Array[Int], slotAvClicks: Array[Int]): Int = {

    assert(revenue.length == slotAvClicks.length)
    val pairs = revenue.sorted.zip(slotAvClicks.sorted)
    pairs.foldLeft(0)((acc, pair) => acc + (pair._1 * pair._2))
  }

  def main(args: Array[String]): Unit = {
    val arrLen = readInt()
    val profitPerClick = readLine().split(" ").map( el => el.toInt)
    val avNumClicks = readLine().split(" ").map( el => el.toInt)
    assert(arrLen == profitPerClick.length & arrLen == avNumClicks.length)
    print(solve(profitPerClick, avNumClicks))
  }

}
