package com.evolutiongaming.bootcamp.basics

import scala.io.Source

object ControlStructuresHomework {
  sealed trait Command
  object Command {
    final case class Divide(dividend: Double, divisor: Double) extends Command
    final case class Sum(numbers: List[Double]) extends Command
    final case class Average(numbers: List[Double]) extends Command
    final case class Min(numbers: List[Double]) extends Command
    final case class Max(numbers: List[Double]) extends Command
  }

  final case class ErrorMessage(value: String)

  final case class Result(value: Double) {
    override def toString: String = value.toString
  }

  def parseCommand(x: String): Either[ErrorMessage, Command] = {
    val h :: tl = x.trim.split("\\s+").toList.filter(x => x != "")
    val dtl = tl.map(x => Try(x.toDouble)).map(x=>x.toOption)

    if (dtl.exists(x => x.isEmpty))
      Left(ErrorMessage("Not every argument is convertible to Double"))
    else if (dtl.isEmpty)
      Left(ErrorMessage("No arguments provided"))
    else
      h match {
        case "divide" => dtl match {
          case x :: y :: Nil => Right(Command.Divide(dtl(0).get, dtl(1).get))
          case _         => Left(ErrorMessage(s"Wrong number of parameters for divide"))
        }
        case "sum"     => Right(Command.Sum(dtl.flatMap(x => x)))
        case "average" => Right(Command.Average(dtl.flatMap(x => x)))
        case "min"     => Right(Command.Min(dtl.flatMap(x => x)))
        case "max"     => Right(Command.Max(dtl.flatMap(x => x)))
        case _         => Left(ErrorMessage(s"unknown command $h"))
      }
  }

  def calculate(x: Command): Either[ErrorMessage, Result] = {
    import Command._
    x match {
      case Divide(_, 0) => Left(ErrorMessage("Division by 0"))
      case Divide(a, b) => Right(Result(a / b))
      case Sum(as)      => Right(Result(as.reduce(_ + _)))
      case Average(as)  => Right(Result(as.reduce(_ + _) / as.length))
      case Min(as)      => Right(Result(as.min))
      case Max(as)      => Right(Result(as.max))
    }
  }

  def renderResult(x: Result): String = {
    x.toString
  }

  def process(x: String): String = {
    (for {
      cmd <- parseCommand(x)
      res <- calculate(cmd)
    } yield res).fold(x => s"Error: ${x.value}", x => x.toString)
  }

  def main(args: Array[String]): Unit =
    Source.stdin.getLines() map process foreach println
}
