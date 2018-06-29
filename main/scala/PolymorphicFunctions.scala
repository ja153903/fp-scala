object PolymorphicFunctions {
  // monomorphic function
  def binarySearch(ds: Array[Double], key: Double): Int = {
    def go(low: Int, high: Int): Int = {
      if (low > high) - 1
      else {
        val mid2 = (low + high) / 2
        val d = ds(mid2)
        if (d == key) mid2
        else if (d < key) go(mid2+1, high)
        else go(low, mid2-1)
      }
    }
    go(0, ds.length-1)
  }

  // polymorphic function
  def binarySearch[@specialized A](ds: Array[A], key: A, greaterThan: (A, A) => Boolean): Int = {
    @annotation.tailrec
    def go(low: Int, high: Int): Int = {
      if (low > high) -1
      else {
        val mid = (low + high) / 2
        val d = ds(mid)
        if (!greaterThan(d, key) && !greaterThan(key, d)) mid
        else if (greaterThan(d, key)) go(low, mid-1)
        else go(mid+1, high)
      }
    }
    go(0, ds.length-1)
  }

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(prev: Int, cur: Int): Boolean = {
      if (cur == as.length - 1) gt(as(prev), as(cur))
      else gt(as(prev), as(cur)) && go(cur, cur+1)
    }
    if (as.length <= 1) true
    else go(0, 1)
  }

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = f(a, _)

  def compose[A,B,C](f: B => C, g: A => B): A => C = g andThen f

  def main(args: Array[String]): Unit = {
    println(isSorted(Array(1, 2, 3, 4), (a: Int, b: Int) => a <= b))
    println(partial1(5, (a: Int, b: Int) => a + b)(4))
    println(compose((x: Int) => x*x, (y: Int) => y+y)(4))
  }
}
