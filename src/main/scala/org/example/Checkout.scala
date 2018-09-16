package org.example

import org.example.Items.{Apple, Item, Orange}
import org.joda.money.Money
import org.joda.money.format.MoneyFormatterBuilder

import scala.annotation.tailrec

class Checkout(offers: List[Offer]) {

  val formatter = new MoneyFormatterBuilder().appendCurrencySymbolLocalized().appendAmountLocalized().toFormatter()

  /**
    * Takes a list of items, calculates the total cost, subtracts any applicable discounts
    * and returns the amount to pay as a string
    * @param items list of items
    * @return amount to pay
    */
  def getAmountToPay(items: List[String]): String = {
    val itemList = getItemList(items, List[Item]())
    val total = getTotalCost(itemList, Money.zero(Items.currency))
    val discounts = getDiscounts(itemList)
    val amountToPay = applyDiscounts(total, discounts)
    formatter.print(amountToPay)
  }

  @tailrec
  private def applyDiscounts(money: Money, discounts: List[Money]): Money = {
    if(discounts.isEmpty) {
      return money
    }
    applyDiscounts(money.minus(discounts.head),discounts.tail)
  }

  @tailrec
  private def getItemList(itemsIn: List[String],itemsOut: List[Item]): List[Item] = {
    if(itemsIn.isEmpty){
      return itemsOut
    }
    ItemConverter.getItem(itemsIn.head) match {
      case Some(item) => getItemList(itemsIn.tail, item::itemsOut)
      case None => getItemList(itemsIn.tail, itemsOut)
    }
  }

  @tailrec
  private def getTotalCost(items: List[Item], total: Money): Money = {
    if(items.isEmpty) {
      return total;
    }
    getTotalCost(items.tail, total.plus(items.head.price))
  }

  private def getDiscounts(items: List[Item]): List[Money] = {
    for (offer <- offers) yield offer.discount(items)
  }

}

/**
  * Takes a list of items as arguments and initialises a Checkout instance with current offers
  */
object Checkout extends App {
  val offers = List[Offer](new MultiPurchaseOffer(Apple.getClass,2), new MultiPurchaseOffer(Orange.getClass,3))
  val checkout = new Checkout(offers)
  println("Total cost: " + checkout.getAmountToPay(args.toList))
}
