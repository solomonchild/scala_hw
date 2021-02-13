package com.evolutiongaming.bootcamp.basics.adt

final case class Board private (game: Game, hands: List[Hand])
object Board {
  def create(game: Game, hands: List[Hand]): Option[Board] = ???
}
