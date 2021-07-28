package Greedy

import scala.annotation.tailrec

object MoneyChange {

  def solve(targetVal: Int): Array[Int] = {

    val coinSet = Array(1,5, 10)

    @tailrec
    def _solve(coins: Array[Int]): Array[Int] = {
      val currVal = coins.zip(coinSet).foldLeft(0)( (acc, coinPair) => acc + coinPair._1 * coinPair._2)
      val missingVal = targetVal - currVal
      if(missingVal == 0) {
        coins
      } else {
        val maxIndex = coinSet.zipWithIndex.filter(coinIdx => coinIdx._1 <= missingVal).maxBy(
          coinIdx => coinIdx._1)._2
        val newCoins = coins.updated(maxIndex, coins(maxIndex) + 1)
        _solve(newCoins)
      }
    }
    val initCoins = Array.fill(coinSet.length)(0)
    _solve(initCoins)

  }

  def calcMinCoins(targetVal: Int): Int = {
    val coinsNeeded = solve(targetVal)
    coinsNeeded.sum
  }

}
