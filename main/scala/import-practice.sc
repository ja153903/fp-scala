def stuffWithBigInteger(): Unit = {
  import java.math.BigInteger.{
    ONE => _,
    TEN,
    ZERO => JAVAZERO
  }
  println("TEN: " + TEN)
  println("ZERO: " + JAVAZERO)
}

stuffWithBigInteger()