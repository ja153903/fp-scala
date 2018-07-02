import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FuturesTest {
  def sleep(millis: Long): Unit = {
    Thread.sleep(millis)
  }

  def doWork(index: Int): Int  = {
    sleep((math.random * 1000).toLong)
    index
  }

  def main(args: Array[String]): Unit = {
    val someRange: Range = 1 to 5
    someRange.foreach(index => {
      val f = Future {
        doWork(index)
      }

      f.onComplete{
        case Success(_) => println("Future success")
        case Failure(e) => println("Future failed " + e)
      }
    })

    sleep(1000)
    println("Done")
  }
}
