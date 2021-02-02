package com.evolutiongaming.bootcamp.basics

import ClassesAndTraits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import org.scalacheck.Arbitrary._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import java.security.InvalidParameterException

class ClassesAndTraitsSpec
    extends AnyFlatSpec
    with ScalaCheckDrivenPropertyChecks {

  import ClassesAndTraits.Rect2d
  "Rect2d" should "be correct" in {
    val rec = Rect2d(Point(1, 2), Point(4, 5))
    rec.area shouldEqual 9.0 +- 0.001
    rec.minX shouldEqual 1.0
    rec.maxX shouldEqual 4.0

    rec.minY shouldEqual 2.0
    rec.maxY shouldEqual 5.0
  }

  import ClassesAndTraits.Triangle2d
  "Triangle2d" should "be correct" in {
    val rec = Triangle2d(Point(1, 1), Point(2, 2), Point(3, 1))
    rec.area shouldEqual 1.0 +- 0.001
    rec.minX shouldEqual 1.0
    rec.maxX shouldEqual 3.0

    rec.minY shouldEqual 1.0
    rec.maxY shouldEqual 2.0
  }

  import ClassesAndTraits.Triangle3d
  "Triangle3d" should "be correct" in {
    val rec = Triangle3d(Point(1, 1, 0), Point(2, 2, 0), Point(3, 1, 0))
    rec.surfaceArea shouldEqual 2.0 +- 0.001
    rec.minX shouldEqual 1.0
    rec.maxX shouldEqual 3.0

    rec.minY shouldEqual 1.0
    rec.maxY shouldEqual 2.0

    rec.minZ shouldEqual 0.0
    rec.maxZ shouldEqual 0.0

    val rec2 = Triangle3d(Point(1, 1, 1), Point(2, 2, 1), Point(3, 1, 1))
    rec.surfaceArea shouldEqual 2.0 +- 0.001
    rec.minX shouldEqual 1.0
    rec.maxX shouldEqual 3.0

    rec.minY shouldEqual 1.0
    rec.maxY shouldEqual 2.0
  }

  import ClassesAndTraits.Cuboid
  "Cuboid" should "be correct" in {
    val rec = Cuboid(Point(1, 1, 1), 5, 5, 5)
    rec.surfaceArea shouldEqual 150.0 +- 0.001
    rec.volume shouldEqual 125.0
    rec.minX shouldEqual 1.0
    rec.maxX shouldEqual 6.0

    rec.minY shouldEqual 1.0
    rec.maxY shouldEqual 6.0

    rec.minZ shouldEqual 1.0
    rec.maxZ shouldEqual 6.0
  }
}
