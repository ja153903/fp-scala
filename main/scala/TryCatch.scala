object TryCatch {
  def main(args: Array[String]): Unit = {
    args foreach (arg => countLines(arg))
  }

  import scala.io.Source
  import scala.util.control.NonFatal

  def countLines(filename: String): Unit = {
    println()
    var source: Option[Source] = None
    try {
      source = Some(Source.fromFile(filename))
      val size = source.get.getLines.size
      println(s"file $filename has $size lines")
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception! $ex")
    } finally {
      for (s <- source) {
        println(s"Closing $filename")
        s.close
      }
    }
  }
}
