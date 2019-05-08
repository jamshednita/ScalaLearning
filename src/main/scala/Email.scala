object Email {
  def apply(username: String, domain: String) = username + "@" + domain

  def unapply(email: String): Option[(String,String)] ={
    val strArr : Array[String] = email.split("@")

    if(strArr.nonEmpty && strArr.length == 2)
      Some(strArr(0), strArr(1))
    else
      None
  }

  def main(args: Array[String]): Unit = {
    "martin@sapient.com" match {
      case Email(username, domain)  => println(s"Username: $username and domain: $domain")
    }
  }
}

