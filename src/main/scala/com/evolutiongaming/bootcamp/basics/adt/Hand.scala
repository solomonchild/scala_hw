package com.evolutiongaming.bootcamp.basics.adt

final case class Hand private (game: Game, ranks: List[Rank], suits: List[Suit])

object Hand {
  def create(game: Game, ranks: List[Rank], suits: List[Suit]): Option[Hand] = {
    val len = game match {
      case Game.TexasHoldem => 2
      case Game.OmahaHoldem => 4
    }
    if (
      ranks.length != len || suits.length != len || ranks.length != suits.length
    )
      None
    else Some(Hand(game, ranks, suits))
  }
}
