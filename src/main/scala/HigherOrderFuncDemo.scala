object HigherOrderFuncDemo extends App{
  def apply(f: Int => String, v:Int):String = f(v)

  val dec = new Decorator("[", right = "]")
  println(apply(dec.layout, 7))
}

class Decorator(val left: String, val right: String){
  def layout[A](x: A): String = left + x.toString + right
}