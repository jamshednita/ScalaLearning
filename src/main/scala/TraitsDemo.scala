import scala.collection.mutable.ArrayBuffer

object Demo2 /*extends App*/ {
  // If we extends Scala.App trait then all statement inside the object will be executed. Here we don't need a main method
  // and the code will act like a script.
  // println("Demo2 extends App")
  def main(args : Array[String]) : Unit = {


    val itr01 = new IntIterator(10)
    println(itr01.next())
    println(itr01.next())

    val dog01 = new Dog(name = "Doggy")
    val cat01 = new Dog(name = "Catty")

    var petArr = ArrayBuffer.empty[Pet]
    petArr.append(dog01)
    petArr.append(cat01)

    petArr.foreach(pet => println(pet.name))

  }

}

trait Iterator[A]{
  def hasNext : Boolean
  def next() : A
}

class IntIterator(to:Int) extends Iterator[Int]{
  private var current = 0
  override def hasNext : Boolean = to > current

  override def next() : Int = {
    if(hasNext){
      val temp = current
      current+=1
      temp
    }else 0
  }

}

trait Pet{
  var name : String
}

class Dog(var name: String) extends Pet
class Cat(var name: String) extends Pet
