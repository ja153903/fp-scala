def checkY(y: Int) = {
  for {
    x <- Seq(99, 100, 101)
  } {
    val str = x match {
      case `y` => "found y" // use other quotes to match the y parameter
      case i: Int => s"int: $i"
    }
    println(str)
  }
}

checkY(100)

for {
  x <- Seq(1, 2, 2.7, "one", "two")
} {
  val str = x match {
    case _: Int | _: Double => s"a number: $x"
    case "one" => "string one"
    case _: String => s"other one: $x"
    case _ => s"unexpected value: $x"
  }
  println(str)
}