package com.evolutiongaming.bootcamp.basics

import java.security.InvalidParameterException

object Basics {
  def gcd(a: Int, b: Int): Int = (a, b) match {
    case (0, 0) => throw new IllegalArgumentException("gcd(0,0) is undefined")
    case (_, 0) => Math.abs(a)
    case _      => gcd(Math.abs(b), a % b)
  }

  def lcm(a: Int, b: Int): Int =
    if (List(a, b).exists(_ == 0))
      throw new IllegalArgumentException("lcm(a,0) and lcm(0, b) are undefined")
    else Math.abs(a * b) / gcd(a, b)
}
