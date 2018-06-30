/*
A trait is an interface where we may choose to implement some functions
So given this List class, it can be of two things: Nil or Cons
When the list is empty, you would have a Nil object
but when you have something in the List, you can use the Cons class
to construct a list

class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

Since we've made List[+A], we then have that
List[Nothing] is a subtype of some List[A]
 */
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A] (head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail(x: List[Int]): List[Int] = x match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n == 0) l
    else l match {
      case Nil => Nil
      case Cons(_, ls) => drop(ls, n-1)
    }
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs)(f)
    case _ => l
  }

  def setHead[A](l: List[A], value: A): List[A] = l match {
    case Nil => List(value)
    case Cons(_, ls) => Cons(value, ls)
  }
}

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def main(args: Array[String]): Unit = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // this one is the first to run
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }
    /*
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    For this case, we have the list List(1, 2, 3, 4, 5)
    It matches the 3, 4, 5 at the end, leaving the x and y to be 1 and 2
    respectively so x + y = 3
     */

    println(x)

    println(tail(List(2, 3, 4, 5)))

}
