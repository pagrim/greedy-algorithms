import org.scalatest.flatspec.AnyFlatSpec
import Greedy.FractionalKnapsack

class TestFractionalKnapsack extends AnyFlatSpec {

  "A FractionalKnapsack" should "give known correct value" in {

    val values = Array(60f, 100f, 120f)
    val weights = Array(20f, 50f, 30f)
    val capacity = 50f
    val calcMax = FractionalKnapsack.solve(values, weights, capacity)
    assert(Math.abs(calcMax - 180) < 0.0001)
  }


}
