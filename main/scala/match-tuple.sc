val langs = Seq(
  ("Scala", "Martin", "Odersky"),
  ("Clojure", "Rich", "Hickey"),
  ("Lisp", "John", "McCarthy")
)

for (tuple <- langs) {
  tuple match {
    case ("Scala", _, _) => println("Found Scala")
    case (lang, first, last) =>
      println(s"Found other language: $lang ($first, $last)")
  }
}

// guards in case clauses
for (i <- Seq(1, 2, 3, 4)) {
  i match {
    case _ if i % 2 == 0 => println(s"even: $i")
    case _ => println(s"odd: $i")
  }
}