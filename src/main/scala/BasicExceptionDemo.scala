object BasicExceptionDemo extends App {
  override def main(args: Array[String]): Unit = {
    lazy val zero = 0
    try {
      val result = zero / zero
    } catch {
      case e1: ArithmeticException => println("caught arithmetic exception"); e1.printStackTrace()
      case _: Exception => println("caught exception")
    }
    finally {
      println("performing cleanup")
    }
  }
}
