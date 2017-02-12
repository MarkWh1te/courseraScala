package week4

object InsertionSort {
  def issort(xs: List[Int]): List[Int] = xs match {
    case List()  ⇒ List()
    case y :: ys ⇒ insert(y, issort(ys))
  }
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List()  ⇒ List(x)
    case y :: ys ⇒ if (x <= y) x :: xs else y :: insert(x, ys)
  }
  def main(args: Array[String]): Unit = {
    val testList = List(7, 2, 4, 56, 6)
    val soredList = issort(testList)
    println(testList)
    println(soredList)
  }
}
