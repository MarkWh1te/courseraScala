package week4

object PatternMatching {
  def matchTest(x: Any): Any = x match {
    case x: Int     ⇒ "this is a Int"
    case x: String  ⇒ x
    case x: Boolean ⇒ if (x) "true" else "flase"
  }
  def main(args: Array[String]): Unit = {
    println(matchTest(1))
    println(matchTest("this is a test"))
    println(matchTest(true))
  }
}
