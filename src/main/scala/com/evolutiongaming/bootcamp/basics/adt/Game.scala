package com.evolutiongaming.bootcamp.basics.adt

trait Game
object Game {
  case object TexasHoldem extends Game
  case object OmahaHoldem extends Game
}
