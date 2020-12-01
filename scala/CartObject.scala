import scala.collection.mutable.ListBuffer
import scala.math.BigDecimal.int2bigDecimal
import scala.util.Try

object CartObject {

  import ShoppingSKU.ShoppingSKUList;
  //For adding the totals up
  var TotalList = new ListBuffer[Int]

  var PriceSKUList = scala.collection.mutable.Map[String, String]()


  def splitSKU(item:String): Unit ={
    //Split the string from the first comma
    val getPos = item.indexOf(",")
    val splitString = item.splitAt(getPos)
    val count = splitString._2.count(_ == ',')
    val UnitsSold = ShoppingSKUList(splitString._1.trim)

    count match {
      case 1 => addRegToTotal(splitString._1,splitString._2.replace(",","").toInt,UnitsSold);
      case 2 => val splitSpecial = splitString._2.splitAt(splitString._2.indexOf(",",splitString._2.indexOf(",")+1))
        addSpecToTotal(splitString._1.replace(",",""),splitSpecial._1.replace(",","").toInt,UnitsSold,splitSpecial._2.replace(",",""));
    }

  }

  def addRegToTotal(SKU:String,Price:Int,UnitsSold:Int): Unit ={
    //If the item is not on special offer then a simple calculation is suffice
    println("---------------Add to Regular------------")
    println("SKU "+SKU+ " Price "+Price+" Units sold "+UnitsSold)
    TotalList += Price * UnitsSold
    val result = TotalList.sum
    println("Total = "+result)
  }

  def addSpecToTotal(SKU:String,Price:Int,UnitsSold:Int,Special:String): Unit ={
    //This is a special, you are going to need some work done
    println("---------------Add to Special------------")
    println("SKU "+SKU+ " Price "+Price+" Units sold "+UnitsSold)
    println("special text = "+Special)
    val specialRed = Special.replace(" for ",",")
    val amount = specialRed.substring(specialRed.indexOf(",")+1).toInt
    val numOf = specialRed.splitAt(specialRed.indexOf(","))
    println("amount = "+amount+" numOf = "+numOf._1)
    //Divide the number to find the quotient amount and its remainder.
    val (quotient, remainder) = UnitsSold /% numOf._1.toInt

    println("quo = "+quotient+" remainder = "+remainder)
    //Adding totals to list
    TotalList += Price * remainder.toInt
    TotalList += amount * quotient.toInt
    val result = TotalList.sum

    println("Total = "+result)
  }

}
