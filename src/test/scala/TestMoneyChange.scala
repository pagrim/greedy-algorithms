import org.scalatest.flatspec.AnyFlatSpec

class TestMoneyChange extends AnyFlatSpec {

  "A money change" should "give known correct value" in {

    assert(MoneyChange.calcMinCoins(2) == 2)
    assert(MoneyChange.calcMinCoins(28) == 6)
  }
}




