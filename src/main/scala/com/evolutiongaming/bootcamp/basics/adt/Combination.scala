package com.evolutiongaming.bootcamp.basics.adt
package com.evolutiongaming.bootcamp.basics.adt

sealed trait Combination

sealed trait Straight extends Combination
sealed trait Flush extends Combination
sealed trait ThreeKind extends Combination
sealed trait Pair extends Combination

object Combination {
  final case object StraightFlush extends Straight with Flush
  final case object FourOfKind extends Combination
  final case object FullHouse extends ThreeKind with Pair
  final case object Flush extends Flush
  final case object Straight extends Straight
  final case object ThreeKind extends ThreeKind
  final case object TwoPair extends Combination
  final case object Pair extends Combination
  final case object HighCard extends Combination
}
