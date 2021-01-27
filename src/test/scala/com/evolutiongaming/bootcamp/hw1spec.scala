package com.evolutiongaming.bootcamp.basics

import Basics._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import java.security.InvalidParameterException

class BasicsSpec extends AnyFlatSpec with ScalaCheckDrivenPropertyChecks {
  "lcm" should "derive least common multiple of 213 and 109" in {
    lcm(213, 109) shouldEqual 23217
  }

  forAll { (x: Int, y: Int) =>
    whenever(x == 0 || y == 0) {
      an[IllegalArgumentException] should be thrownBy lcm(x, y)
    }
  }

  "lcm" should "work for negative arguments" in {
    all(
      lcm(213, 109) :: lcm(-213, 109) :: lcm(213, -109) :: lcm(-213, -109) :: Nil
    ) shouldEqual 23217
  }

  "gcd" should "work when exactly one of the arguments is 0" in {
    forAll { x: Int =>
      whenever(x != 0) {
        gcd(0, x) shouldEqual Math.abs(x)
        gcd(x, 0) shouldEqual Math.abs(x)
      }
    }
  }

  an[IllegalArgumentException] should be thrownBy gcd(0, 0)

  "gcd" should "have gcd(a,b) == gcd(-a,b) == gcd(a,-b) == gcd(-a,-b)" in {
    all(
      gcd(24, 18) :: gcd(-24, 18) :: gcd(24, -18) :: gcd(-24, -18) :: Nil
    ) shouldEqual 6
  }
}
