object BasicExceptionDemo extends App {

  override def main(args: Array[String]): Unit = {
    lazy val zero = 0
    try {
      val result = zero / zero
    } catch {
      case e: ArithmeticException => println("caught arithmetic exception")
      case _                      => println("caught exception")
    } finally {
      println("performing cleanup")
    }
  }
}
