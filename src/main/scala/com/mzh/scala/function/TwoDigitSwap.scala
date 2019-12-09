package com.mzh.scala.function

object TwoDigitSwap {
  def main(args: Array[String]): Unit = {
    var i :Int = 10
    var j :Int = 20

    println(s"i = ${i} , j = ${j}")

    j = i+j
    i = j-i
    j = j-i


    println(s"i = ${i} , j = ${j}")


    //位运算交换

    j = i^j
    i = j^i
    j = j^i

    println(s"i = ${i} , j = ${j}")

  }
}
