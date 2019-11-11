package com.mzh.scala

object Function3 {
  def main(args: Array[String]): Unit = {
    def f1(i : Int): Unit ={
      println(i)
    }

    def f2(f : (Int)=>Unit): Unit ={
      f(10)
    }

    //原始调用
    f2(f1)
    //匿名函数调用
    f2((i : Int)=>{println(i)})
   //函数体一行省略大括号
    f2((i : Int)=> println(i))
    //参数类型已经定义可以省略
    f2((i)=>println(i))
    //参数只用一次可以用下划线代替
    f2(println(_))
    //就一个参数参数可以省略
    f2(println)

    //返回求和
    def f3(f : (Int,Int)=>Int): Int ={
      f(10,20)
    }

    //匿名函数调用
    println(f3((i:Int,j:Int)=>{i+j}))
    //函数体一行省略大括号
    println(f3((i : Int,j : Int)=>i+j))
    //参数类型已经定义可以省略
    println(f3((i,j)=>i+j))
    //参数只用一次可以用下划线代替
    println(f3(_+_))

  }
}
