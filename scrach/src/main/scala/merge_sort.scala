package week5

object MergeSort {
  // def main(args: Array[String]): Unit = {
  // val testList = List(7, 2, 4, 56, 6)
  // val soredList = msort(testList)
  // println(soredList)
  // }
  def msort(list: List[Int]): List[Int] = {
    val n = list.length / 2
    if (n == 0) list
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys)            ⇒ ys
        case (xs, Nil)            ⇒ xs
        case (x :: xs1, y :: ys1) ⇒ if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      val (left, right) = list splitAt n
      merge(msort(left), msort(right))
    }
  }
}
