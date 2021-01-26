
package com.evolutiongaming.bootcamp.basics

import Basics._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class BasicsSpec extends AnyFlatSpec with ScalaCheckDrivenPropertyChecks {
  "lcm" should "derive least common multiple of 213 and 109" in {
    lcm(213, 109) shouldEqual 23217
  }

  "lcm" should "derive least common multiple of 0 and 109" in {
    lcm(0, 109) shouldEqual 0
  }

  "lcm" should "derive least common multiple of 0 and 0" in {
    lcm(0, 0) shouldEqual 0
  }

  "gcd" should "derive greatest common divisor of 24 and 12" in {
    gcd(24, 18) shouldEqual 6
  }
}