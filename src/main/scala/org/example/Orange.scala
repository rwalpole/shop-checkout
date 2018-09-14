package org.example

import org.joda.money.Money

case class Orange() extends Item {

  def price: Money = {
    Orange.price
  }

}

object Orange extends Item {

  def apply: Orange = new Orange

  val price = Money.of(gbp,0.25d);
}
