import java.io.File
import java.net.{MalformedURLException, URL}
import java.nio.file.Path

import scala.util.Try

object BasicTryValueDemo extends App {

  def filePath(path: String): Try[File] = {
    // creating an File object with null throws NullPointerException which is an unchecked exception
    //Try[A] always returns either Success[A] or Failure[A]
    Try(new File(path))
  }

  override def main(args: Array[String]): Unit = {
    //using a getOrElse to provide a safe value if function returns Failure[File]
    val file = filePath(null).getOrElse(new File("/"))
    println(file.toString)

    //assert failure
    assert(filePath(null).isFailure)
  }

}
