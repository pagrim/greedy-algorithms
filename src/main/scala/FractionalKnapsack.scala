import scala.annotation.tailrec
import scala.io.StdIn.readLine

object FractionalKnapsack {

  def solve(values: Array[Float], weights: Array[Float], initCapacity: Float): Array[Float] = {

    val valuePerWeight = values.zip(weights).map { case (v: Float, w: Float) => v / w }

    @tailrec
    def _solve(items: Array[Float], availItems: Array[Float], capacity: Float): Array[Float] = {
      if (capacity < 0.001 || availItems.sum < 0.001) {
        items
      } else {
        // fetch max index filtering for only unused and available items
        val maxIndex = valuePerWeight.lazyZip(items).lazyZip(availItems).zipWithIndex.filter(
        quad => quad._1._2 == 0 & quad._1._3 > 0).maxBy(
          quad => quad._1._1)._2
        val weightUsed = Math.min(weights(maxIndex), capacity)
        val amountUsed = weightUsed / weights(maxIndex)

        val newCapacity = capacity - weightUsed
        val newItems = items.updated(maxIndex, items(maxIndex) + amountUsed)
        val newAvailItems = availItems.updated(maxIndex, availItems(maxIndex) - amountUsed)

        _solve(newItems, newAvailItems, newCapacity)
      }
    }

    val initItems = Array.fill(values.length)(0.0f)
    val initAvailItems = Array.fill(values.length)(1.0f)
    _solve(initItems, initAvailItems, initCapacity)
  }

  def calcMaxValue(values: Array[Float], weights: Array[Float], initCapacity: Float): Float = {
    assert(values.length == weights.length)
    val optimalItems = solve(values, weights, initCapacity)
    optimalItems.zip(values).foldLeft(0f)((acc, pair) => acc + pair._1 * pair._2)
  }

  def main(args: Array[String]): Unit = {
    val numItemsCapacity = readLine().split(" ")
    val numItems = numItemsCapacity(0).toInt
    val capacity = numItemsCapacity(1).toFloat
    val inputs = for (_ <- 1 to numItems) yield readLine()
    val valWeights = inputs.map(ipt => ipt.split(" "))
    val values = valWeights.map(arr => arr(0).toFloat).toArray
    val weights = valWeights.map(arr => arr(1).toFloat).toArray
    print(calcMaxValue(values, weights, capacity))
  }
}
