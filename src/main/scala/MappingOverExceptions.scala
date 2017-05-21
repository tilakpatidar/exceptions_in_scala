import java.io.File

import scala.util.Try

object MappingOverExceptions extends App {
  def filePath(path: String): Try[File] = {
    Try(new File(path))
  }

  override def main(args: Array[String]): Unit = {
    val filePaths = List("/", "/home", "/tmp", null)
    val fileObjs = filePaths.map(filePath)
    //this will print a list of Success[File] with last element Fail[File]
    println(fileObjs)

    val listOfPaths = fileObjs
      .filter(_.isSuccess)
      .map(_.get)
      .map(_.toString)

    println(listOfPaths)
  }

}
