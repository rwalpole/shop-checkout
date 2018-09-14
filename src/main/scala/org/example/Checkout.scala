package org.example

import org.joda.money.format.MoneyFormatterBuilder
import org.joda.money.{CurrencyUnit, Money}

class Checkout {

  val formatter = new MoneyFormatterBuilder().appendCurrencySymbolLocalized().appendAmountLocalized().toFormatter()

  /**
    * Takes a list of items and calculates the total cost, returning the value as a string
    * @param items
    * @return
    */
  def getTotal(items: List[String]): String = {
    formatter.print(getTotal(items, Money.zero(CurrencyUnit.GBP)))
  }

  private def getTotal(items: List[String], total: Money): Money = {
    if(items.isEmpty) {
      return total;
    }
    val item = ItemConverter.getItem(items.head)
    getTotal(items.tail, total.plus(getItemPrice(item)))
  }

  private def getItemPrice(maybeItem: Option[Item]): Money = {
    maybeItem match {
      case Some(item) => item.price
      case None => Money.zero(CurrencyUnit.GBP)
    }
  }

}

object Checkout extends App {

  val checkout = new Checkout
  println("Total cost: " + checkout.getTotal(args.toList))
  
}
