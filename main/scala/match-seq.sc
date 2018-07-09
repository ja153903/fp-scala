import scala.collection.immutable.{Nil, List}

val nonEmptySeq = Seq(1, 2, 3, 4, 5)
val emptySeq = Nil

def seqToString[T](seq: Seq[T]): String = seq match {
  case head +: tail => s"($head +: ${seqToString(tail)})"
  case Nil => "(Nil)"
}

for (seq <- Seq(nonEmptySeq)) println(seqToString(seq))

val nonEmptyList = List(1, 2, 3, 4, 5)
val emptyList = Nil

def listToString[T](list: List[T]): String = list match {
  case head :: tail => s"($head :: ${listToString(tail)})"
  case Nil => "(Nil)"
}

for (list <- List(nonEmptyList, emptyList)) println(listToString(list))
