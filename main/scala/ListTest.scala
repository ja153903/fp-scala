import scala.collection.immutable.{List => list}

object ListTest {

  def reverse[A](l: list[A]): list[A] = {
    if (l.tail.isEmpty) list(l.head)
    else reverse(l.tail) ++ list(l.head)
  }

  def addOne(l: list[Int]): list[Int] = {
    if (l.tail.isEmpty) list(l.head + 1)
    else l.head+1 :: addOne(l.tail)
  }

  def betterAddOne(l: list[Int]): list[Int] = l.map(x => x + 1)

  def main(args: Array[String]): Unit = {
    val ll = list(1, 2, 3, 4)

    val ll2 = 4 :: ll

    println(ll2)

    println(reverse(ll))

    println(addOne(ll))

    println(ll.map(x => x + 2))

    println(ll.max)

    println(betterAddOne(ll))

  }

}
