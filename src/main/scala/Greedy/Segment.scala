package Greedy

case class Segment(start: Int, finish: Int)

object Segment {

  def withinSegment(point: Int, segment: Segment): Boolean = {
    point >= segment.start && point <= segment.finish
  }

}
