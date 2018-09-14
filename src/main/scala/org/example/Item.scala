package org.example

import org.joda.money.{CurrencyUnit, Money}

trait Item {

  /** Currency for all Items */
  val gbp = CurrencyUnit.GBP

  /**
    * Returns the price of an Item as a Joda Money object
    * @return
    */
  def price: Money

}
