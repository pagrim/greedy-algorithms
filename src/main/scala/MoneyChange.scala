import scala.annotation.tailrec
import scala.io.StdIn.readInt

object MoneyChange {

  val coinSet: Array[Int] = Array(1,5,10)

  @tailrec
  def _solve(coins: Array[Int], targetVal: Int): Array[Int] = {
    val currVal = coins.zip(coinSet).foldLeft(0)( (acc, coinPair) => acc + coinPair._1 * coinPair._2)
    val missingVal = targetVal - currVal
    if(missingVal == 0) {
      coins
    } else {
      val maxIndex = coinSet.zipWithIndex.filter(coinIdx => coinIdx._1 <= missingVal).maxBy(
        coinIdx => coinIdx._1)._2
      val newCoins = coins.updated(maxIndex, coins(maxIndex) + 1)
      _solve(newCoins, targetVal)
    }
  }

  def calcMinCoins(targetVal: Int): Int = {

    val initCoins = Array.fill(coinSet.length)(0)
    val coinsNeeded = _solve(initCoins, targetVal)
    coinsNeeded.sum
  }

  def main(args: Array[String]): Unit = {
    val target = readInt()
    print(calcMinCoins(target))
  }

}
