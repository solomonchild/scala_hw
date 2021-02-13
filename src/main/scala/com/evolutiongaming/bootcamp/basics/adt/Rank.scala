package com.evolutiongaming.bootcamp.basics.adt

abstract class Rank(score: Int)
object Rank {
  final case object LowAce extends Rank(1)
  final case object Two extends Rank(2)
  final case object Three extends Rank(3)
  final case object Four extends Rank(4)
  final case object Five extends Rank(5)
  final case object Six extends Rank(6)
  final case object Seven extends Rank(7)
  final case object Eight extends Rank(8)
  final case object Nine extends Rank(9)
  final case object Ten extends Rank(10)
  final case object Jack extends Rank(11)
  final case object Queen extends Rank(12)
  final case object King extends Rank(13)
  final case object Ace extends Rank(14)

}
