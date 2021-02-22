package com.evolutiongaming.bootcamp.basics

import Implicits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import java.security.InvalidParameterException

class ImplicitHWSpec extends AnyFlatSpec {
  import TypeclassTask._
  "HashCode" should "work as an 'extensions' method" in {
    "abc".hash shouldBe 96354
  }

  import Task1._
  "Ordering for Money" should "work when using sorting" in {
    List(Money(2), Money(100), Money(1)).sorted shouldBe List(
      Money(1),
      Money(2),
      Money(100)
    )
  }

  "Show User" should "work as an extension method on a User" in {
    import Task2._
    User("123", "John").show shouldBe "123, John"
  }

  "Parse user" should "give User back for valid strings and an error in other cases" in {
    import Task3._
    "lala".parse[User] shouldBe Left("Cannot parse User")
    "1,John".parse[User] shouldBe Right(User("1", "John"))
    " 1, John ".parse[User] shouldBe Right(User("1", "John"))
    " 1, John".parse[User] shouldBe Right(User("1", "John"))
    " 1,John".parse[User] shouldBe Right(User("1", "John"))
    "1, John".parse[User] shouldBe Right(User("1", "John"))
  }

  "Type-safe ===" should "work for the same types" in {
      import Task4._
    1 ==== 1 shouldBe true
    1 ==== 2 shouldBe false
    //"1 === 3.0" shouldNot compile
  }
}
