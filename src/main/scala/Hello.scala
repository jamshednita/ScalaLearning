object Hello extends App {
  //println("Hello, World!")

  // Code to generate new value with exactly same existing as String

  (1 to 500).foreach(index => {
    val valField = "<Column name=" + "\"" + s"Value$index" + "\""
    val expField = "expr=\"${Column" + s"$index}" + "\""
    val isNewField = "isNew=\"true\""
    val dTypeField = "dType=\"String\" />"
    println(valField + " " + expField + " " + isNewField + " " + dTypeField)
  }
  )

  // Code to generate same value as existing as String

  (1 to 500).foreach(index => {
    val valField = "<Column name=" + "\"" + s"Column$index" + "\""
    val expField = "expr=\"${Column" + s"$index}" + "\""
    val isNewField = "isNew=\"false\""
    val dTypeField = "dType=\"String\" />"
    println(valField + " " + expField + " " + isNewField + " " + dTypeField)
  }
  )

}
