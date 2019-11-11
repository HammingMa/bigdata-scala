package com.mzh.scala

//不使用变量交换两个数的值

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
