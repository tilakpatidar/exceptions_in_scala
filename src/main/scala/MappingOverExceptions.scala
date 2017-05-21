import java.io.File

import scala.util.{Failure, Success, Try}

object MappingOverExceptions extends App {

  def filePath(path: String): Try[File] =
    //Creating new File with null results in NullPointerException which is an unchecked exception
    //Try[A] always returns either Success[A] or Failure[A]
    Try(new File(path))

  def exampleOne(): Unit = {
    val filePaths = List("/", "/home", "/tmp", null)
    val fileObjs  = filePaths.map(filePath)

    //this will print a list of Success[File] with last element Fail[File]
    println(fileObjs)

    val listOfPaths = fileObjs
      .filter(_.isSuccess)
      .map(_.get)
      .map(_.toString)

    println(listOfPaths)
  }

  def exampleTwo(): Unit = {
    val filePaths = List("/", "/home", "/tmp", null)
    val fileObjs  = filePaths.map(filePath)

    //this will print a list of Success[File] with last element Fail[File]
    println(fileObjs)

    val listOfPaths = fileObjs.map({
      case Failure(e) => filePath("/").get.toString
      case Success(e) => e.toString
    })

    println(listOfPaths)
  }

  override def main(args: Array[String]): Unit = {
    exampleOne
    exampleTwo
  }

}
