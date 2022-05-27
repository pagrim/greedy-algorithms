import org.scalatest.flatspec.AnyFlatSpec

class TestMaxSalary extends AnyFlatSpec {

  "A max salary" should "give known correct value" in {

    assert(MaxSalary.getMaxSalary(Array(21, 2)) == 221)
    assert(MaxSalary.getMaxSalary(Array(9, 4, 6, 1, 9)) == 99641)
    assert(MaxSalary.getMaxSalary(Array(23, 39, 92)) == 923923)

  }
}





