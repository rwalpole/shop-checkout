package org.example

object ItemConverter {

  /**
    * Takes an item name as a string and converts it to an Item object
    * Uses Option in case the string value is not recognised
    * @param itemName
    * @return
    */
  def getItem(itemName: String): Option[Item] = {
    if(itemName.toLowerCase.equals("apple")) {
      return Some(new Apple)
    }
    else if(itemName.toLowerCase.equals("orange")) {
      return Some(new Orange)
    }
    else None // FIXME - it is not specified what should happen if the item is not recognised

  }

}
