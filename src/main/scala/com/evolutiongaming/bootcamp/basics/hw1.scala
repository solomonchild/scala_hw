package com.evolutiongaming.bootcamp.basics

import java.security.InvalidParameterException

object Basics {
  def gcd(a: Int, b: Int): Option[Int] = (a, b) match {
    case (0, 0) => None
    case (_, 0) => Some(Math.abs(a))
    case _      => gcd(Math.abs(b), a % b)
  }

  def lcm(a: Int, b: Int): Option[Int] = {
    if (List(a, b).exists(_ == 0)) None
    else {
      val g = gcd(a, b)
      g match {
        case None    => None
        case Some(x) => Some(Math.abs(a * b) / x)
      }
    }
  }
}
