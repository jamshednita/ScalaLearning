object NestedFunc extends App{

  def factorial(num: Int): Int = {
    def fact(n: Int): Int ={
      if(n<=1) 1
      else n*fact(n-1)
    }

    fact(num)
  }

  println("factorial of 6 = "+factorial(6))

}
