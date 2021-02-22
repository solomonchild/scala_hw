package com.evolutiongaming.bootcamp.basics

object Implicits {
  object TypeclassTask {
    trait HashCode[T] {
      def hash(e: T): Int
    }

    object HashCode {
      // TODO: Implement me a summoner
      def apply[T](implicit instance: HashCode[T]): HashCode[T] = instance
    }

    implicit class HashCodeSyntax[A](x: A) {
      // TODO: Implement syntax so I can "abc".hash
      def hash(implicit a: HashCode[A]) = a.hash(x)
    }

    implicit val strHash: HashCode[String] = (s: String) => s.hashCode
    // assert("abc".hash == 96354)
  }

  object Task1 {

    final case class Money(amount: BigDecimal)

    implicit val moneyOrdering: Ordering[Money] = (x: Money, y: Money) => x.amount.compare(y.amount)

    //assert( List(Money(2), Money(100), Money(1)).sorted == List(Money(1), Money(2), Money(100)))
  }

  object Task2 {

    trait Show[T] { // fancy toString
      def show(entity: T): String
    }

    final case class User(id: String, name: String)

    implicit val userShow: Show[User] = (e: User) => s"${e.id}, ${e.name}"

    implicit class ShowOps[T](t: T) {
      def show(implicit s: Show[T]) = s.show(t)
    }

    // assert(User("123", "John").show == "123, John")
  }

  object Task3 {
    type Error = String

    trait Parse[T] { // invent any format you want or it can be csv string
      def parse(entity: String): Either[Error, T]
    }

    final case class User(id: String, name: String)

    implicit class parseOps[T](s: String) {
      def parse[T](implicit p: Parse[T]) = p.parse(s)
    }

    implicit val userParser: Parse[User] = (s: String) => {
      val Pat = "\\s*(\\d+),\\s*(\\w+)\\s*".r
      s match {
        case Pat(id, name) => Right(User(id, name))
        case _             => Left("Cannot parse User")
      }
    }

    // assert("lala".parse[User] == Left("Cannot parse User"))
    // assert("1,John".parse[User] == Right(User("1", "John")))
    // assert(" 1, John ".parse[User] == Right(User("1", "John")))
    // assert(" 1, John".parse[User] == Right(User("1", "John")))
    // assert(" 1,John".parse[User] == Right(User("1", "John")))
    // assert("1, John".parse[User] == Right(User("1", "John")))
  }

  // made ==== instead of ===, so tests could compile, since 
  // otherwise there was a clash with some other implicit pulled in by testing framework

  object Task4 {
    trait Eq[T] {
      def ====(a: T, B: T): Boolean
    }
    implicit class EqOps[T](a: T) {
      def ====(b: T) = {
        a == b
      }
    }
    assert(1 ==== 1)
    assert(!(1 ==== 2))
    // assert(!(1 === 3.0))

  }

}
