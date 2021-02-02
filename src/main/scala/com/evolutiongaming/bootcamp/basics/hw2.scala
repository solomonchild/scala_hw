package com.evolutiongaming.bootcamp.basics

object ClassesAndTraits {

  sealed trait Located2d {
    def x: Double
    def y: Double
  }

  sealed trait Located3d extends Located2d {
    def z: Double
  }

  sealed trait Bounded2d {
    def minX: Double
    def maxX: Double
    def minY: Double
    def maxY: Double
  }

  sealed trait Bounded3d extends Bounded2d {
    def minZ: Double
    def maxZ: Double
  }

  sealed trait Shape2d extends Located2d with Bounded2d {
    def area: Double = 0
  }

  sealed trait Shape3d extends Located3d with Bounded3d {
    def volume: Double
    def surfaceArea: Double
  }

  final case class Point(x: Double, y: Double, z: Double = 0) extends Shape3d {

    override def volume: Double = 0
    override def surfaceArea: Double = 0

    override def minX: Double = x
    override def maxX: Double = x
    override def minY: Double = y
    override def maxY: Double = y
    override def minZ: Double = z
    override def maxZ: Double = z

    def +(i: Double): Point = Point(x + i, y + i, z + i)
    def +(other: Point): Point = Point(x + other.x, y + other.y, z + other.z)
    def -(other: Point): Point = Point(x - other.x, y - other.y, z - other.z)

    def abs: Double = Math.sqrt(x * x + y * y + z * z)
    def *(i: Double): Point = Point(x * i, y * i, z * i)
    def /(i: Double): Point = this.*(1 / i);
  }

  final case class Circle(centerX: Double, centerY: Double, radius: Double)
      extends Shape2d {
    override def x: Double = centerX
    override def y: Double = centerY

    override def minX: Double = centerX - radius
    override def maxX: Double = centerX + radius
    override def minY: Double = centerY - radius
    override def maxY: Double = centerY + radius
    override def area: Double = 2 * math.Pi * radius * radius
  }

  def barycentricCoords(a: Point, b: Point, c: Point): Point = (a + b + c) / 3.0
  final case class Triangle2d(a: Point, b: Point, c: Point) extends Shape2d {
    override def x: Double = barycentricCoords(a, b, c).x
    override def y: Double = barycentricCoords(a, b, c).y

    override def minX: Double = List(a, b, c).map(i => i.x).min
    override def maxX: Double = List(a, b, c).map(i => i.x).max
    override def minY: Double = List(a, b, c).map(i => i.y).min
    override def maxY: Double = List(a, b, c).map(i => i.y).max

    override def area: Double = {
      val A = (a - b).abs
      val B = (c - b).abs
      val C = (a - c).abs

      val sp = (A + B + C) / 2
      // Heron's formula
      math.sqrt(sp * (sp - A) * (sp - B) * (sp - C))
    }
  }

  //           *------* <-- top
  //           |      |
  //           |      |
  // right --> *------*
  //
  final case class Rect2d(left: Point, top: Point) extends Shape2d {
    override def x: Double = ((left + top) / 2).x
    override def y: Double = ((left + top) / 2).y

    override def minX: Double = Math.min(left.x, top.x)
    override def maxX: Double = Math.max(left.x, top.x)
    override def minY: Double = Math.min(left.y, top.y)
    override def maxY: Double = Math.max(left.y, top.y)
    def height: Double = (left.y - top.y).abs
    def width: Double = (left.x - top.x).abs

    override def area: Double = {
      height * width
    }
  }

  // pos denotes bottom-left corner
  final case class Cuboid(pos: Point, w: Double, h: Double, d: Double)
      extends Shape3d {
    override def x: Double = pos.x
    override def y: Double = pos.y
    override def z: Double = pos.z

    override def minX: Double = pos.x
    override def maxX: Double = pos.x + w

    override def minY: Double = pos.y
    override def maxY: Double = pos.y + h

    override def minZ: Double = pos.z
    override def maxZ: Double = pos.z + d

    override def surfaceArea: Double = h * w * 2 + h * d * 2 + w * d * 2
    override def volume: Double = h * w * d
  }

  final case class Triangle3d(a: Point, b: Point, c: Point) extends Shape3d {
    override def x: Double = barycentricCoords(a, b, c).x
    override def y: Double = barycentricCoords(a, b, c).y
    override def z: Double = barycentricCoords(a, b, c).z

    override def minX: Double = List(a, b, c).map(i => i.x).min
    override def maxX: Double = List(a, b, c).map(i => i.x).max
    override def minY: Double = List(a, b, c).map(i => i.y).min
    override def maxY: Double = List(a, b, c).map(i => i.y).max
    override def minZ: Double = List(a, b, c).map(i => i.z).min
    override def maxZ: Double = List(a, b, c).map(i => i.z).max

    override def surfaceArea: Double = Triangle2d(a, b, c).area * 2
    override def volume: Double = 0
  }
}
