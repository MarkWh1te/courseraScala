package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else
      pascal(c - 1, r - 1) + pascal(c, r - 1);
  }

  def balance(chars: List[Char]): Boolean = {
    def process(count: Int, rest: List[Char]): Boolean =
      if (count < 0) false else
        if (rest.isEmpty) (count == 0) else
          if (rest.head == '(') process(count+1, rest.tail) else
            if (rest.head == ')') process(count-1, rest.tail) else process(count, rest.tail)

    process(0, chars)
  }

  def countChange(money: Int, coins: List[Int]): Int = {
    if(coins.isEmpty) 0
    else if (money < coins.head) countChange(money,coins.tail)
    else if (money == coins.head) 1 + countChange(money,coins.tail)
    else countChange(money-coins.head,coins) + countChange(money,coins.tail)
  }

}
