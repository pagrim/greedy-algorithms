import org.scalatest.flatspec.AnyFlatSpec

class TestAdvertRevenue extends AnyFlatSpec {

  "A Advert Revenue object" should "give known correct value" in {

    assert(AdvertRevenue.solve(Array(23), Array(39))==897)
    assert(AdvertRevenue.solve(Array(1, 3, -5), Array(-2, 4, 1))==23)
    assert(AdvertRevenue.solve(Array(0), Array(0))==0)
  }




}




