package com.evolutiongaming.bootcamp.basics

import Basics._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import java.security.InvalidParameterException

class BasicsSpec extends AnyFlatSpec with ScalaCheckDrivenPropertyChecks {
  "lcm" should "derive least common multiple of 213 and 109" in {
    lcm(213, 109) shouldEqual Some(23217)
  }

  "lcm" should "not be defined for arguments that are zero" in {
    forAll { x: Int =>
        lcm(x, 0) shouldEqual None
    }
    forAll { x: Int =>
        lcm(0, x) shouldEqual None
    }
  }


  "lcm" should "work for negative arguments" in {
    all(
      lcm(213, 109) :: lcm(-213, 109) :: lcm(213, -109) :: lcm(
        -213,
        -109
      ) :: Nil
    ) shouldEqual Some(23217)
  }

  "gcd" should "work when exactly one of the arguments is 0" in {
    forAll { x: Int =>
      whenever(x != 0) {
        gcd(0, x) shouldEqual Some(Math.abs(x))
        gcd(x, 0) shouldEqual Some(Math.abs(x))
      }
    }
  }

  "gcd" should "not be defined for (0,0)" in {
    gcd(0, 0) shouldEqual None
  }

  "gcd" should "have gcd(a,b) == gcd(-a,b) == gcd(a,-b) == gcd(-a,-b)" in {
    all(
      gcd(24, 18) :: gcd(-24, 18) :: gcd(24, -18) :: gcd(-24, -18) :: Nil
    ) shouldEqual Some(6)
  }
}
