import scala.collection.immutable.{List => list}

def makeList(strings: String*): list[String] = {
  if (strings.isEmpty)
    null
  else
    strings.toList
}

val listStrings: list[String] = makeList("pokemon", "strings")