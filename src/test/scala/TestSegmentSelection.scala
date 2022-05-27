import org.scalatest.flatspec.AnyFlatSpec

class TestSegmentSelection extends AnyFlatSpec {

  "A segment" should "identify points within its range" in {
    assert(Segment.withinSegment(5, Segment(4,6)))
    assert(Segment.withinSegment(3, Segment(1,6)))
    assert(!Segment.withinSegment(7, Segment(1,6)))
  }

  "A segment selection" should "give correct minimum points case 1" in {

    val segmentsCase1 = Array(Segment(1, 3), Segment(2, 5), Segment(3, 6))
    assert(SegmentSelection.selectMinPoints(segmentsCase1) sameElements Array(3))
  }

  "A segment selection" should "give correct minimum points case 2" in {

    val segmentsCase2 = Array(Segment(4, 7), Segment(1, 3), Segment(2, 5), Segment(5, 6))
    assert(SegmentSelection.selectMinPoints(segmentsCase2) sameElements Array(3, 6))
  }
}





