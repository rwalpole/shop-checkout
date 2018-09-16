package org.example

import org.joda.money.{CurrencyUnit, Money}

object Items {

  /** Currency for all Items */
  val currency = CurrencyUnit.GBP

  sealed trait Item {

    /**
      * Returns the price of an Item as a Joda Money object
      * @return
      */
    def price: Money

  }

  case class Apple() extends Item {

    def price: Money = Apple.price

  }

  object Apple extends Item {

    def apply: Apple = new Apple

    val price = Money.of(currency,0.6d);
  }

  case class Orange() extends Item {

    def price: Money = Orange.price

  }

  object Orange extends Item {

    def apply: Orange = new Orange

    val price = Money.of(currency,0.25d);
  }
}

