object Demo {
  def main(args: Array[String]): Unit ={
    //println("Returned Value : "+addInt(5,7))

    val personList = Person("John Smith", 28, "Male") :: Person("Maria", 19, "Female") :: Person("Sony", 16, "Female") :: Person("Peter", 43, "Male") :: Nil
    //var output = List[String]()
    //var names = personList.foldLeft("")((curr, per)=>curr.concat(per.name))

    var names = personList.foldLeft(List.empty[String])((current, person)=>prepareNameList(current, person))
    names.foreach(name => println(name))

    val partialFunc: PartialFunction[Person, Person] = {
      case x:Person if x.Sex == "Male" && x.age>20 => x
      case x:Person if x.Sex == "Female" && x.age>18 => x
    }

    var eligibleForMarriage = personList collect partialFunc
    eligibleForMarriage.foreach(person => println(person.name))
    //println(names)
    //println(output)

    /*var demoList = List[String]()
    demoList ::= "xyz"
    demoList ::= "abc"

    println("demo list  == > "+demoList)*/

  }

  /*def prepareNameList(initial : List[String], person:Person) : List[String] = {
    var modifiedList : List[String] = initial
    person.Sex match {
      case "Male" => modifiedList ::= ("Mr. "+person.name+", "+person.age)
      case "Female" => modifiedList ::= ("Ms. "+person.name+", "+person.age)
    }
    return modifiedList
  }*/

  def prepareNameList(initial : List[String], person:Person) : List[String] = {
    person.Sex match {
      case "Male" => s"Mr. ${person.name}, ${person.age}" :: initial
      case "Female" => s"Ms. ${person.name}, ${person.age}" :: initial
    }
  }
  /*def addInt(a:Int, b:Int): Int={
    var sum:Int=0
    sum = a+b
    return sum
  }*/

}

case class Person (name: String, age: Int, Sex: String)