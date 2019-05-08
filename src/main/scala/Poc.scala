import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date

object Poc {
  def main(args : Array[String]) : Unit = {
    var boolStr = true
    var dateStr = "1900-01-01"

    println(" Boolean string ==  " + String.valueOf(boolStr))
    println("Parsed DateTime == " + new java.sql.Date(((new SimpleDateFormat("yyyy-MM-dd")).parse(dateStr)).getTime))
    //println("===== Time Format ===== "+dateStr)

    val dtStr : String = null//"2012/07/16 15:25:00.000"
    var dtStrRepl = "2012/07/26 15:25:00.000"
    var dtStrUnix = "2012-07-26 15:25:00.000"

    var unixFormat = "yyyy-MM-dd hh:mm:ss.FFF"
    var inFormat = "yyyy/MM/dd hh:mm:SS.fff"

    if(dtStr != null)
      println( "dtStr ===== " +new java.sql.Date(((new SimpleDateFormat("yyyy/MM/dd hh:mm:SS")).parse(dtStr.substring(0,19))).getTime))
    else
      println( "dtStr ===== " +new java.sql.Date(((new SimpleDateFormat("yyyy/MM/dd hh:mm:SS")).parse(dtStrRepl.substring(0,19))).getTime))

    //println("Parsed DateTime 2 == " + new java.sql.Date(((new SimpleDateFormat("yyyy/MM/dd hh:mm:SS")).parse(dtStr)).getTime))

    //var inDt:Date =  (new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS")).parse(dtStrRepl)

    val sqlDtStr="10/18/2018 3:30:45 AM"
    var outUnixDt = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS")).parse(dtStrRepl)))

    println("Output Unix Date === "+outUnixDt)

    println("Timestamp === "+Timestamp.valueOf(dtStrUnix))

    println("Current Time to Unix Format ==== "+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Calendar.getInstance().getTime())))

    //var yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd").format((new SimpleDateFormat("yyyyMMdd")).parse("20191010"))
    println(new SimpleDateFormat("yyyy-MM-dd").format((new SimpleDateFormat("yyyyMMdd")).parse("20191010")))

    println("T and Z date format == "+ new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format((new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa")).parse("2/22/2019 8:59:02 AM")))



  }
}
