package org.example

import org.example.Items.{Apple, Item, Orange}
import org.scalatest.{FlatSpec, Matchers}

class OfferSpec extends FlatSpec with Matchers {

  "A Buy One Get One Free offer on apples" should "give no discount for a single apple" in {
    val offer = new MultiPurchaseOffer(Apple.getClass,2)
    val items = List[Item](Apple)
    offer.discount(items).toString should be ("GBP 0.00")
  }

  it should "give one free apple when two are purchased" in {
    val offer = new MultiPurchaseOffer(Apple.getClass,2)
    val items = List[Item](Apple,Apple)
    offer.discount(items).toString should be ("GBP 0.60")
  }

  it should "give one free apple when three are purchased" in {
    val offer = new MultiPurchaseOffer(Apple.getClass,2)
    val items = List[Item](Apple,Apple,Apple)
    offer.discount(items).toString should be ("GBP 0.60")
  }

  it should "give two free apples when four are purchased" in {
    val offer = new MultiPurchaseOffer(Apple.getClass,2)
    val items = List[Item](Apple,Apple,Apple,Apple)
    offer.discount(items).toString should be ("GBP 1.20")
  }

  "A Three for the Price of Two offer on oranges" should "give no discount for two oranges" in {
    val offer = new MultiPurchaseOffer(Orange.getClass,3)
    val items = List[Item](Orange,Orange)
    offer.discount(items).toString should be ("GBP 0.00")
  }

  it should "give one free orange when three are purchased" in {
    val offer = new MultiPurchaseOffer(Orange.getClass,3)
    val items = List[Item](Orange,Orange,Orange)
    offer.discount(items).toString should be ("GBP 0.25")
  }

  it should "give one free orange when five are purchased" in {
    val offer = new MultiPurchaseOffer(Orange.getClass,3)
    val items = List[Item](Orange,Orange,Orange,Orange,Orange)
    offer.discount(items).toString should be ("GBP 0.25")
  }

  it should "give two free oranges when six are purchased" in {
    val offer = new MultiPurchaseOffer(Orange.getClass,3)
    val items = List[Item](Orange,Orange,Orange,Orange,Orange,Orange)
    offer.discount(items).toString should be ("GBP 0.50")
  }

}
