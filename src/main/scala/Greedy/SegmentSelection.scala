package Greedy

import scala.annotation.tailrec

/*
The idea of this algorithm is to select segments by drawing the fewest number of points such that every segment contains
at least one point. The segments are lines on an integer axis.
 */
object SegmentSelection {


  def selectMinPoints(segments: Array[Segment]): Array[Int] = {

    val startSortedSegments = segments.sortBy(seg => seg.start)

    @tailrec
    def _selectMinPoints(segments: Array[Segment], points: Array[Int]): Array[Int] = {
      segments match {
        case Array() => points
        case Array(_*) =>
          val minFinishSeg = segments.minBy( seg => seg.finish)
          val minFinish = minFinishSeg.finish
          val newPoints = points :+ minFinish
          val newSegs = segments.dropWhile(seg => Segment.withinSegment(minFinish, seg))
         _selectMinPoints(newSegs, newPoints)
      }
    }
    val initPoints = Array[Int]()
    _selectMinPoints(startSortedSegments, initPoints)
  }


}
