# shop-checkout
To run this program you will need Scala and SBT installed.

Clone this repository and then..
~~~~
cd ./shop-checkout
sbt
compile
run apple apple orange apple
~~~~
If all is well this will return a total cost of £2.05

Discounts of two for the price of one are applied to apples and three for the price of two to oranges.

~~~~
run apple apple
~~~~
should return the same cost as..
~~~~
run apple
~~~~
and..
~~~~
run orange orange orange
~~~~
should return the same as..
~~~~
run orange orange
~~~~

