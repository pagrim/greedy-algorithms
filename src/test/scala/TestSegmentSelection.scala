import org.scalatest.flatspec.AnyFlatSpec
import Greedy.{Segment, SegmentSelection}

class TestSegmentSelection extends AnyFlatSpec {

  "A segment selection" should "give correct minimum points case 1" in {

    val segments = Array(Segment(1, 3), Segment(2, 5), Segment(3, 6))
    assert(SegmentSelection.selectMinPoints(segments) sameElements Array(3))
  }

  "A segment selection" should "give correct minimum points case 2" in {

    val segments = Array(Segment(4, 7), Segment(1, 3), Segment(2, 5), Segment(5, 6))
    assert(SegmentSelection.selectMinPoints(segments) sameElements Array(3, 6))
  }
}





