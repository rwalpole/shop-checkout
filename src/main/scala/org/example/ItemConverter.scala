package org.example

import org.example.Items.{Apple, Item, Orange}

object ItemConverter {

  /**
    * Takes an item name as a string and converts it to an Item object
    * Uses Option in case the string value is not recognised
    * @param itemName
    * @return
    */
  def getItem(itemName: String): Option[Item] = {
    if(itemName.toLowerCase.equals("apple")) {
      return Some(Apple)
    }
    else if(itemName.toLowerCase.equals("orange")) {
      return Some(Orange)
    }
    else None // FIXME - it is not specified what should happen if the item is not recognised

  }

}
