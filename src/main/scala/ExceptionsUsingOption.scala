object ExceptionsUsingOption extends App {

  def divide(x: Int, y: Int): Option[Int] =
    try {
      Option[Int](x / y)
    } catch {
      case _ => None
    }

  override def main(args: Array[String]): Unit = {
    val result: Option[Int] = divide(42, 0)
    println(result.getOrElse(0))
  }
}
