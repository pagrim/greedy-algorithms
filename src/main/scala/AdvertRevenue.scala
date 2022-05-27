import scala.io.StdIn.{readInt, readLine}

object AdvertRevenue {

  def solve(revenue: Array[Long], slotAvClicks: Array[Long]): Long = {

    assert(revenue.length == slotAvClicks.length)
    val pairs = revenue.sorted.reverse.zip(slotAvClicks.sorted.reverse)
    pairs.foldLeft(0L)((acc, pair) => acc + (pair._1 * pair._2))
  }

  def main(args: Array[String]): Unit = {
    val arrLen = readInt()
    val profitPerClick = readLine().split(" ").map( el => el.toLong)
    val avNumClicks = readLine().split(" ").map( el => el.toLong)
    assert(arrLen == profitPerClick.length & arrLen == avNumClicks.length)
    print(solve(profitPerClick, avNumClicks))
  }

}
