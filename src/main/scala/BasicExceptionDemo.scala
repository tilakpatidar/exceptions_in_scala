import scala.util.control.NonFatal

object BasicExceptionDemo extends App {

  override def main(args: Array[String]): Unit = {
    lazy val zero = 0
    try {
      val result = zero / zero
    } catch {
      case e: ArithmeticException => println("caught arithmetic exception")
      case NonFatal(t)            => println("non fatal caught")
      case _                      => println("something really weird happened")
    } finally {
      println("performing cleanup")
    }
  }
}
