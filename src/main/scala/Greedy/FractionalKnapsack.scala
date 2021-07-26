package Greedy

import scala.annotation.tailrec

object FractionalKnapsack {


  def solve(values: Array[Float], weights: Array[Float], initCapacity: Float): Float = {

    val valuePerWeight = values.zip(weights).map{ case (v: Float,w: Float) => v/w }

    @tailrec
    def _solve(items: Array[Float], capacity: Float): Array[Float] = {
            if(capacity < 0.001) {
              items
            } else {
              // fetch max index of unused items
              val maxIndex = valuePerWeight.zip(items).zipWithIndex.filter(triple => triple._1._2 == 0).maxBy(
                triple => triple._1._1)._2
              val weight = Math.min(weights(maxIndex), capacity)
              val amount = weight/weights(maxIndex)
              val newCapacity = capacity - weight
              val newItems = items.updated(maxIndex, items(maxIndex) + amount)
              _solve(newItems, newCapacity)
            }
    }

    assert(values.length == weights.length)
    val initItems = Array.fill(values.length)(0.0f)
    val optimalItems = _solve(initItems, initCapacity)
    optimalItems.zip(values).foldLeft(0f)( (acc, pair) => acc + pair._1 * pair._2 )
  }

}
