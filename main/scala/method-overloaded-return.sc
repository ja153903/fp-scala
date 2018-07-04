import scala.collection.immutable.{List => list}
object StringUtilV1 {
  def joiner(strings: String*): String = strings.mkString("-")
  def joiner(strings: list[String]): String = joiner(strings: _*)
}

println(
  StringUtilV1.joiner(
    list("programming", "scala")))

