package org.example

import org.scalatest.{FlatSpec, Matchers}

class CheckoutSpec extends FlatSpec with Matchers {

  "A Checkout" should "total the cost of the items supplied in a list" in {
    val checkout = new Checkout
    val items = List[String]("Apple","APPLE","orange")
    checkout.getTotal(items) should be ("£1.45")
  }

  it should "return zero cost if the list is empty" in {
    val checkout = new Checkout
    val items = List[String]()
    checkout.getTotal(items) should be ("£0.00")
  }

}
