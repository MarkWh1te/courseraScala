package week2
// somethings i write when i am watching coursera lecture notes
object notes {
  // def main(args: Array[String]) =
  // println(product(x => x+1,1,4))
  // println(factorial(10))
  // println(sum(x=>x*x)(1,10))
  // println(sumCurrystyle(x ⇒ x * x)(1, 10))
  // println()

  def product(f: Int ⇒ Int, a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f, a + 1, b)

  def factorial(a: Int): Int =
    productCurrystyle(x ⇒ x)(1, a)

  def sum_currying_withourt_sugar(f: Int ⇒ Int): (Int, Int) ⇒ Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }

  def sum(f: Int ⇒ Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  // https://en.wikipedia.org/wiki/Haskell_Curry
  def sumCurrystyle = (f: Int ⇒ Int) ⇒ ((a: Int, b: Int) ⇒ if (a > b) 0 else f(a) + sum(f)(a + 1, b))

  // def productCurrystyle:Int=>Int = (f:Int=>Int)=>((a:Int,b:Int)=>if (a > b) 1 else f(a)*productCurrystyle(f)(a+1,b))
  // def productCurrystyle = (f:Int=>Int)=>((a:Int,b:Int)=>if (a > b) 1 else f(a)*productCurrystyle(f)(a+1,b))
  def productCurrystyle(f: Int ⇒ Int)(a: Int, b: Int): Int = if (a > b) 1 else f(a) * productCurrystyle(f)(a + 1, b)
}

object functionData {
  // def main(args: Array[String]) = {
  // val a = new Rational(10, 20)
  // val b = new Rational(24, 3)
  // println(a.neg)
  // println(b)
  // println(a.add(b))
  // println(a add b)
  // println(a.mul(b))
  // val x = new Rational(1, 3)
  // val y = new Rational(5, 7)
  // val z = new Rational(3, 2)
  // println(x.add(y).mul(z))
  // }
  class Rational(x: Int, y: Int) {
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    def numer = x / gcd(x, y)
    def denom = y / gcd(x, y)
    def add(r: Rational) = {
      new Rational(
        r.numer * denom + r.denom * numer,
        r.denom * denom
      )
    }
    def mul(r: Rational) = {
      new Rational(
        numer * r.denom - denom * r.numer,
        r.denom * denom
      )
    }
    def neg() = {
      new Rational(numer * (-1), denom)
    }
    override def toString = numer + "/" + denom
  }
}
