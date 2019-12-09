package com.mzh.scala.function

object Function4 {
  def main(args: Array[String]): Unit = {

    //阶乘的定义 一个数的阶乘等于这个数乘以这个数减一的阶乘，1的阶乘为1
    def !!(i : Int):Int ={
      if(i == 1){
        1
      }else{
        i * !!(i-1)
      }
    }

    println(!!(5))


    //惰性加载

    def sum(i : Int,j : Int): Int ={
      println("执行sum方法")
      i+j
    }

    lazy val s = sum(5,6)
    //val s = sum(5,6)
    println("-------------")
    println(s)

    //异常处理
    try{
      val s = 10/0
    }catch{

      case ex:ArithmeticException => println("捕获了除数为0的异常！")
      case ex:Exception => println("捕获了异常")
    }finally {
      println("finally...........")
    }

  }
}
