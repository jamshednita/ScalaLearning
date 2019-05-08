object CCD {
  val message1 = Message(sender = "Apple@apple.com", recipient = "Mango@mango.com", body = "2 kg apples")
  val message2 = Message(sender = "Apple@apple.com", recipient = "Mango@mango.com", body = "2 kg apples")
  val copyMessage = message1.copy(recipient = "Mango@mango.com", body = "2 kg apples")

  print(s"""${message1} == ${message2} == ${copyMessage}""")

  case class Message(var sender: String, var recipient: String, var body: String)
}

