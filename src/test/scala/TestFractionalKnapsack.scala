import org.scalatest.flatspec.AnyFlatSpec

class TestFractionalKnapsack extends AnyFlatSpec {

  "A FractionalKnapsack" should "give known correct value case 1" in {

    val values = Array(60f, 100f, 120f)
    val weights = Array(20f, 50f, 30f)
    val capacity = 50f
    val calcMax = FractionalKnapsack.calcMaxValue(values, weights, capacity)
    assert(Math.abs(calcMax - 180) < 0.0001)
  }

  "A FractionalKnapsack" should "give known correct value case 2" in {

    val values = Array(500f)
    val weights = Array(30f)
    val capacity = 10f
    val calcMax = FractionalKnapsack.calcMaxValue(values, weights, capacity)
    assert(Math.abs(calcMax - 166.6667) < 0.0001)
  }

  "A FractionalKnapsack" should "give known correct value case 3" in {

    val values = Array(500f)
    val weights = Array(30f)
    val capacity = 1000f
    val calcMax = FractionalKnapsack.calcMaxValue(values, weights, capacity)
    assert(Math.abs(calcMax - 500) < 0.0001)
  }


}
