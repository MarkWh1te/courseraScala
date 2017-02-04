// package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    println(balance(":-)".toList))
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
     println(balance(":-)"))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1 else pascal(c-1,r)+pascal(c,r-1)
  /**
   * Exercise 2
   */
  // def balance(chars: List[Char],counter:Int=0): Boolean ={
  //   def count(char:Char)  =
  //     if ( char == "(" ) 1
  //     else if ( char == ")" ) -1
  //     else 0

  //   if (chars.isEmpty)
  //     counter == 0
  //   else if (counter<0) false
  //   else balance(chars.tail,count(chars.head)+counter)
  // }

  def balance(chars: List[Char]): Boolean = {
    def process(count: Int, rest: List[Char]): Boolean =
      if (count < 0) false else
        if (rest.isEmpty) (count == 0) else
          if (rest.head == '(') process(count+1, rest.tail) else
            if (rest.head == ')') process(count-1, rest.tail) else process(count, rest.tail)

    process(0, chars)
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (coins.isEmpty) 0
    else if (money == coins.head) 1 + countChange(money,coins.tail)
    else if (money < coins.head) countChange(money,coins.tail)
    else countChange(money - coins.head,coins) + countChange(money,coins.tail)
  }
