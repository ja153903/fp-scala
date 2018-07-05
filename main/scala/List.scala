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
//sealed trait List[+A]
//case object Nil extends List[Nothing]
//case class Cons[+A] (head: A, tail: List[A]) extends List[A]
//
//object List {
//  def sum(ints: List[Int]): Int = ints match {
//    case Nil => 0
//    case Cons(x, xs) => x + sum(xs)
//  }
//
//  def product(ds: List[Double]): Double = ds match {
//    case Nil => 1.0
//    case Cons(0.0, _) => 0.0
//    case Cons(x, xs) => x * product(xs)
//  }
//
//  /*
//  Notice how similar the sum and product function are.
//  We can generalize the function by creating a foldRight function
//  which does pattern matching. It takes in the list, the base case
//  and the function as its arguments
//   */
//
//  def foldRight[A, B](l: List[A], z: B)(f: (A, B) => B): B =
//    l match {
//      case Nil => z
//      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
//    }
//
//  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B =
//    l match {
//      case Nil => z
//      case Cons(x, xs) => f(foldLeft(xs, z)(f), x)
//    }
//
//  def sumFold(l: List[Int]): Int = foldRight(l, 0)(_ + _)
//
//  def productFold(l: List[Int]): Int = foldRight(l, 1)(_ * _)
//
//  def length(l:List[Int]): Int = foldRight(l, 0)((_, n) => n + 1)
//
//  def lengthFoldLeft(l: List[Int]): Int = foldLeft(l, 0)((n, _) => 1 + n)
//
//  def tail(x: List[Int]): List[Int] = x match {
//    case Nil => Nil
//    case Cons(_, xs) => xs
//  }
//
//  def drop[A](l: List[A], n: Int): List[A] = {
//    if (n == 0) l
//    else l match {
//      case Nil => Nil
//      case Cons(_, ls) => drop(ls, n-1)
//    }
//  }
//
//  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
//    case Cons(x, xs) if f(x) => dropWhile(xs)(f)
//    case _ => l
//  }
//
//  def setHead[A](l: List[A], value: A): List[A] = l match {
//    case Nil => Nil
//    case Cons(_, ls) => Cons(value, ls)
//  }
//
//  // The apply function allows us to use the List(...) syntax
//  /*
//  From Text:
//
//  By calling this function apply and placing it in the companion object, we can
//  invoke it with syntax like List(1,2,3,4) or List("hi","bye") ,
//  with as many values as we want separated by commas (we sometimes
//  call this the list literal or just literal syntax).
//   */
//  def apply[A](as: A*): List[A] = {
//    if (as.isEmpty) Nil
//    else Cons(as.head, apply(as.tail: _*))
//  }
//
//  /*
//  Write a function that will return everything but the last element
//   */
//  def init[A](l: List[A]): List[A] = l match {
//    case Cons(x, Cons(y, Nil)) => Cons(x, Nil)
//    case Cons(x, xs) => Cons(x, init(xs))
//  }
//
//  def main(args: Array[String]): Unit = {
//    val x = List(1, 2, 3, 4, 5) match {
//      case Cons(x, Cons(2, Cons(4, _))) => x
//      case Nil => 42
//      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
//      case Cons(h, t) => h + sum(t)
//      case _ => 101
//    }
//    /*
//    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
//    For this case, we have the list List(1, 2, 3, 4, 5)
//    It matches the 3, 4, 5 at the end, leaving the x and y to be 1 and 2
//    respectively so x + y = 3
//     */
//
//     println(x)
//
////    println(tail(Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))))
//
//    println(productFold(List(1, 2, 3, 4, 5)))
////    println(productFold(Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))))
//
//    println(init(List(1, 2, 3, 4))) // expected List(1, 2, 3)
//    println(length(List(1, 2, 3)))
//    println(lengthFoldLeft(List(1, 2, 3)))
//  }
//}
