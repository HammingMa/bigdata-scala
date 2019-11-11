package com.mzh.scala

import scala.io.StdIn

object ReadLine {
  def main(args: Array[String]): Unit = {
    println("请输入")
    val line: String = StdIn.readLine()

    println(s"line = ${line}")

  }
}
