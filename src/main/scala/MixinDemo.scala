object MixinDemo {

  def main(args:Array[String]): Unit = {
    println(" ==== RUNNING MIXINDEMO ==== ")
    class RichStringIter extends StringIterator(s="teststring") with RichIterator
    val iter = new RichStringIter
    // iter foreach println
    iter.foreach(println)
  }
}

abstract class AbsIterator{
  type T
  def hasNext : Boolean
  def next() : T
}

class StringIterator(s: String) extends AbsIterator{
  override type T = Char
  private var i = 0
  override def hasNext: Boolean = i < s.length

  override def next(): Char = {
    if(hasNext) {
      val ch = s charAt i
      i+=1
      ch
    }else Char.MinValue
  }

}

trait RichIterator extends AbsIterator{
  def foreach(f: T => Unit): Unit = while(hasNext) f(next())
}

/*object StringIteratorTest extends App {
  class RichStringIter extends StringIterator(args(0)) with RichIterator
  val iter = new RichStringIter
  iter foreach println
}*/
