package org.example

import org.joda.money.Money

case class Apple() extends Item {

  def price: Money = {
    Apple.price
  }

}

object Apple extends Item {

  def apply: Apple = new Apple

  val price = Money.of(gbp,0.6d);
}
