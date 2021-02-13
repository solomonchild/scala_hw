package com.evolutiongaming.bootcamp.basics.adt

final case class Card(r: Rank, s: Suit) {
  override def toString = s"$r of $s"
}
