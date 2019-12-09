package com.mzh.scala.function

object AbstractFunction {
  def main(args: Array[String]): Unit = {
    //函数作为参数传递给另一个函数，如果这个函数不需要参数，也不需要返回值，可以直接传递逻辑代码
    //声明方式 ： => Unit

    def test(f: => Unit): Unit ={
      f
    }

    test{
      println("xxxx")
    }

  }
}
