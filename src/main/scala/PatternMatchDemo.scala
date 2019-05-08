object PatternMatchDemo {

  def main(args: Array[String]): Unit = {

    /*val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))
*/
    /*val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
    val someSms = SMS("867-5309", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")
    println(showImportantNotification(someSms, importantPeopleInfo))
    println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
    println(showImportantNotification(importantEmail, importantPeopleInfo))
    println(showImportantNotification(importantSms, importantPeopleInfo))*/

    val phone1 = Phone("Nokia")
    val computer1 = Computer("Dell")

    println(goIdle(phone1))
    println(goIdle(computer1))

    val couch1 = Couch()
    val chair1 = Chair()

    println(findPlaceToSit(couch1))
    println(findPlaceToSit(chair1))
  }


  abstract class Notification
  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showImportantNotification(notification: Notification, importantPeopleInfo:Seq[String]):String = {
    notification match {
      case Email(email, _, _) if importantPeopleInfo.contains(email) => "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) => "You got an SMS from special someone!"
      case other => showNotification(other)
    }
  }

  def showNotification(notification: Notification) :String ={
    notification match {
      case Email(email, title, _) => s"You got an email from ${email} with title: ${title}"
      case SMS(number, msg) => s"You got an sms from $number! Message: $msg"
      case VoiceRecording(name, link) => s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }


  abstract class Device
  case class Phone(model: String) extends Device{
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device{
    def screenSaverOn = "Turning screen saver on .."
  }

  def goIdle(device: Device): String ={
    device match{
      case p:Phone => p.screenOff
      case c:Computer => c.screenSaverOn
    }
  }

  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(furniture: Furniture): String = furniture match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }

}
