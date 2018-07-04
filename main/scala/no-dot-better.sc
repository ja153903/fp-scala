import scala.collection.immutable.{List => list}

def isEven(n: Int) = (n % 2) == 0

// more functional in nature to do it this way
list(1, 2, 3, 4) filter isEven foreach println

