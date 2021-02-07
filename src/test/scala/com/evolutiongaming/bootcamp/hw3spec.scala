package com.evolutiongaming.bootcamp.basics

import ControlStructuresHomework._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import java.security.InvalidParameterException

class ControlStructuresSpec extends AnyFlatSpec {
  "process" should "print errors" in {
    process("divid 1") shouldBe "Error: unknown command divid"
    process(
      "divide s 1.0"
    ) shouldBe "Error: Not every argument is convertible to Double"
  }
  "proces" should "work" in {
    process("sum 1 2 3 4") shouldBe "10.0"
    process("divide 1 2") shouldBe "0.5"
    process("average 1 2 3 4 ") shouldBe "2.5"
    process("min 1 -1 2 3 4 ") shouldBe "-1.0"
    process("max 1 -1 2 3 4 3") shouldBe "4.0"
  }
}
