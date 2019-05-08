object CompanionDemo {

  def apply(base: String, extras: String) = {
    val s = new CompanionDemo(base)
    s.extraData = extras
    s
  }

  def apply(base: String) = new CompanionDemo(base)

  def main(args: Array[String])=
    println(CompanionDemo("Hello","World"))
    println(CompanionDemo("hello"))

}

class CompanionDemo(val jString: String){
  private var extraData=""
  override def toString = extraData + jString
}
