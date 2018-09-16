package org.example

import org.example.Items.{Apple, Orange}
import org.scalatest.{FlatSpec, Matchers}

class CheckoutSpec extends FlatSpec with Matchers {

  "A Checkout" should "total the cost of the items supplied in a list" in {
    val checkout = new Checkout(List[Offer]())
    val items = List[String]("apple","apple","orange")
    checkout.AmountToPay(items) should be ("£1.45")
  }

  it should "return zero cost if the list is empty" in {
    val checkout = new Checkout(List[Offer]())
    val items = List[String]()
    checkout.AmountToPay(items) should be ("£0.00")
  }

  it should "subtract the correct discounts when an offer is applied" in {
    val checkout = new Checkout(List[Offer](new MultiPurchaseOffer(Apple.getClass,2)))
    val items = List[String]("apple","apple")
    checkout.AmountToPay(items) should be ("£0.60")
  }

  it should "subtract the correct discounts when multiple offers are applied" in {
    val checkout = new Checkout(List[Offer](
      new MultiPurchaseOffer(Apple.getClass,2),
      new MultiPurchaseOffer(Orange.getClass,3)))
    val items = List[String]("apple","apple","orange","orange","orange")
    checkout.AmountToPay(items) should be ("£1.10")
  }
}
