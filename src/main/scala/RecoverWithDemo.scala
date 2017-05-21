import java.io.File

import scala.util.{Failure, Try}

object RecoverWithDemo extends App {

  def filePath(path: String): Try[File] =
    //Creating new File with null results in NullPointerException which is an unchecked exception
    //Try[A] always returns either Success[A] or Failure[A]
    Try(new File(path))

  override def main(args: Array[String]): Unit = {
    val filePaths = List("/", "/home", "/tmp", null)
    val fileObjs =
      filePaths
      //Create List[Try[File]]
        .map(filePath)
        //Iterate over List[Try[File]]
        .map(_.recoverWith({
          //recover with allows to swap your failure with another failure
          case e: NullPointerException => Failure(new IllegalArgumentException)
        }))
    println(fileObjs)
  }
}
