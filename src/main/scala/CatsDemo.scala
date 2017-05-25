import cats.implicits._

import scala.util.{Failure, Success, Try}

object CatsDemo extends App {

  override def main(args: Array[String]): Unit = {

    // We have a List[Try[String]] but we actually want a Try[List[String]].
    // we want it to be a Failure if any of the individual Trys was a Failure.
    val listOfTries: List[Try[String]] = List(Failure(new Exception), Success("b"), Success("c"))
    val tryOfList: Try[List[String]]   = listOfTries.sequence

    //Failure(new Exception)
    println(tryOfList)
    val listOfTriesOther: List[Try[String]] = List(Success("a"), Success("b"), Success("c"))
    val tryOfListOther: Try[List[String]]   = listOfTriesOther.sequence

    //Success(List(a, b, c))
    println(listOfTriesOther)
  }
}
