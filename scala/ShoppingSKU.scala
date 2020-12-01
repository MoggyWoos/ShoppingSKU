
object ShoppingSKU {

  var ShoppingSKUList = scala.collection.mutable.Map[String, Int]()


  def CheckSKUExists(SKU: String): Unit ={
    //Check if The SKU Exists Already
    val bool = ShoppingSKUList.contains(SKU)
    //If it does increase the count
    if(bool){
      IncreaseSKUCount(SKU)

    }else{
      //If it doesn't add the sku to our shopping list
      AddSKUToList(SKU)
    }

  }

  def AddSKUToList(SKU: String): Unit ={
    ShoppingSKUList += SKU -> 1;
  }

  def IncreaseSKUCount(SKU: String): Unit ={
    val count = ShoppingSKUList(SKU) + 1
    ShoppingSKUList(SKU) = count
    }

}
