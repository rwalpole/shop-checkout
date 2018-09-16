package org.example

import org.example.Items.Item
import org.joda.money.Money

trait Offer {

  /**
    * Takes the list of items, checks if the current offer applies and if so returns the appropriate discount
    * @param items
    * @return
    */
  def discount(items: List[Item]): Money
}

/**
  * A multi-purchase offer gives one free if multiple are purchase
  * @param c the item class to which the offer applies
  * @param required the number that must be purchased to get the discount
  */
case class MultiPurchaseOffer(c: Class[_<:Item],required: Int) extends Offer {
  override def discount(items: List[Item]): Money = {
    val grouped = items.groupBy(_.getClass)
    grouped.get(c) match {
      case Some(matching) => {
        val free = matching.length / required
        return matching.head.price.multipliedBy(free)
      }
      case None => return Money.zero(Items.currency)
    }
  }
}
