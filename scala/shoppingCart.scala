
import CartObject._
import ShoppingSKU._
object shoppingCart extends App {
  //Create the offers

  val ShoppingList = "A,B,C,D,E,A,B,C,D,A,A,A,A,B,B,C,C,A";
  val SKUPriceList = "A,50,3 for 130" +
    "\nB,30,2 for 45" +
    "\nC,20" +
    "\nD,15"


  ShoppingList.split(",").map(_.toString)
  val list = SKUPriceList.split("\n").toList

  //Run the shopping list
  for (e <- ShoppingList) yield CheckSKUExists(e.toString)
//calculate the total cost
  for (item <- list) splitSKU(item)

}