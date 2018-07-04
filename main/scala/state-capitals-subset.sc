val stateCapitals = Map(
  "Alabama" -> "Montgomery",
  "Alaska" -> "Juneau",
  "Wyoming" -> "Cheyenne")

// Map is an Option[T] object
// This means that when we try
// to get a value that doesn't exist
// then it will return None
// if the value does exist
// then we get the value back
// wrapped around a Some(val)
println(stateCapitals.get("Alabama"))
println(stateCapitals.get("New York"))

// a work around to give a default value that is not None
println(stateCapitals.getOrElse("New York", "No Capital"))

/*
To prevent Option from subclassing types other than Some and None
Scala writes them as a sealed class as follows:

sealed abstract class Option[+A] ... { ... }
 */
