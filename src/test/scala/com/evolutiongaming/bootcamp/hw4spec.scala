package com.evolutiongaming.bootcamp.basics

import Collections._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import java.security.InvalidParameterException

class CollectionsHWSpec extends AnyFlatSpec {
  "runningSum" should "work" in {
    runningSum(Array(1, 2, 3, 4)) shouldBe Array(1, 3, 6, 10)
  }
  "shuffle" should "work" in {
    shuffle(Array(2, 5, 1, 3, 4, 7), 3) shouldBe Array(2, 3, 5, 4, 1, 7)
  }

  "maximumWealth" should "work" in {
    maximumWealth(Array(Array(1, 2, 3), Array(3, 2, 1))) shouldBe 6
  }
  "kidsWithCandies" should "work" in {
    kidsWithCandies(Array(2, 3, 5, 1, 3), 3) shouldBe Array(
      true,
      true,
      true,
      false,
      true
    )
  }
  "maxWidthOfVerticalArea" should "work" in {
    maxWidthOfVerticalArea(
      Array(
        Array(3, 1),
        Array(9, 0),
        Array(1, 0),
        Array(1, 4),
        Array(5, 3),
        Array(8, 8)
      )
    ) shouldBe 3
  }
  "maxDepth" should "work" in {
    maxDepth("(1+(2*3)+((8)/4))+1") shouldBe 3
  }
  "balancedStringSplit" should "work" in {
    balancedStringSplit("RLLLLRRRLR") shouldBe 3
  }
  "matrixBlockSum" should "work" in {
    matrixBlockSum(
      Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)),
      1
    ) shouldBe Array(Array(12, 21, 16), Array(27, 45, 33), Array(24, 39, 28))
  }
}
