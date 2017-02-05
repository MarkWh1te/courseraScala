// somethings i write when i am watching coursera lecture notes
object notes{
  def main(args:Array[String])=
    // println(product(x => x+1,1,4))
    println(factorial(10))

  def product(f:Int=>Int,a:Int,b:Int):Int =
    if (a > b) 1
    else f(a) * product(f,a+1,b)

  def factorial(a:Int):Int =
    product(x=>x,1,a)

}
