package com.evolutiongaming.bootcamp.basics

import scala.io.Source

object Collections {

// https://leetcode.com/problems/running-sum-of-1d-array/
  def runningSum(nums: Array[Int], acc: Int = 0): Array[Int] = {
    nums match {
      case Array(x, _*) => (acc + x) +: runningSum(nums.tail, acc + x)
      case _            => Array()
    }
  }

// https://leetcode.com/problems/shuffle-the-array
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    import scala.language.implicitConversions;
    implicit def asIterable(
        p: (Int, Int)
    ): scala.collection.IterableOnce[Int] = {
      val (a, b) = p
      Array(a, b)
    }
    nums.zip(nums.slice(n, 2 * n)).flatten
  }

// https://leetcode.com/problems/richest-customer-wealth
  def maximumWealth(accounts: Array[Array[Int]]): Int = {
    accounts.map(banks => banks.reduce(_ + _)).max
  }
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
  def kidsWithCandies(
      candies: Array[Int],
      extraCandies: Int
  ): Array[Boolean] = {
    candies.map(cs => !candies.exists(c => c > cs + extraCandies))
  }
// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points
  def maxWidthOfVerticalArea(points: Array[Array[Int]]): Int = {
    val sorted = points.sortWith((a, b) => a(0) < b(0))
    val (a, b) = sorted.zip(sorted.tail).maxBy { case (a, b) =>
      b(0) - a(0)
    }
    b(0) - a(0)
  }

// optional hometask:
//
// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
  def maxDepth(s: String): Int = {
    s.scanLeft(0) { case (acc, el) =>
      if (el == '(') acc + 1 else if (el == ')') acc - 1 else acc
    }.max
  }
// https://leetcode.com/problems/split-a-string-in-balanced-strings
  def balancedStringSplit(s: String, num: Int = 0): Int = {
    if (s.isEmpty) 0
    else {
      val r =
        balancedStringSplit(s.tail, if (s.head == 'L') num + 1 else num - 1)
      if (num == 0) r + 1
      else r
    }
  }
// https://leetcode.com/problems/matrix-block-sum/
  type Matrix = Array[Array[Int]]
  def square(cx: Int, cy: Int, k: Int, mat: Matrix): Matrix = {
    mat
      .slice((cy - k).max(0), (cy + k + 1).min(mat.length))
      .map(row => row.slice((cx - k).max(0), (cx + k + 1).min(row.length)))
  }
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    mat.zipWithIndex.map { case (row, rowI) =>
      row.zipWithIndex.map { case (e, colI) =>
        square(colI, rowI, K, mat).map(r => r.reduce(_ + _)).reduce(_ + _)
      }
    }
  }

  def count(s: String): List[(Char, Int)] = {
    s match {
      case _ if s.isEmpty => Nil
      case _ => {
        val prefix = s.takeWhile(c => c == s.head)
        s.head -> prefix.length :: count(s.drop(prefix.length))
      }
    }
  }

  def scanLeft[T](zero: T)(list: List[T])(f: (T, T) => T): List[T] = {
    list match {
      case x :: xs => zero :: scanLeft(f(zero, x))(list.tail)(f)
      case Nil     => zero :: Nil
    }
  }

  def sortConsideringEqualValues[T](map: Map[T, Int]): List[(Set[T], Int)] = {
    map
      .map { case (k1, v1) =>
        v1 -> map.filter { case (k2, v2) => v2 == v1 }.keys.toSet
      }
      .map(_.swap)
      .toList
      .sortWith { (a, b) => a._2 < b._2 }
  }

}
