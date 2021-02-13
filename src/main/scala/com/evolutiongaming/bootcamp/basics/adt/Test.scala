package com.evolutiongaming.bootcamp.basics.adt

final case class TestCase(board: Board, hands: List[Hand])

final case class TestResult(board: Board, private val hands: List[Hand]) {
  def sortedHands: List[Hand] = ???
}
