import scala.collection.immutable.{List => list}

for (i <- 1 to 10) println(i)

val dogBreed = list(Some("Doberman"), None, Some("Yorkshire Terrier"),
  None, Some("Great Dane"), None, Some("Scottish Terrier"))

// So we don't call methods on None types
val filteredBreeds = for {
  Some(breed) <- dogBreed
  if breed.contains("Terrier") && !breed.startsWith("Yorkshire")
} yield breed

