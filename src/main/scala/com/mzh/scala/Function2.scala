package com.mzh.scala

object Function2 {
  def main(args: Array[String]): Unit = {

    def f1(): Unit = {
      println("hello")
    }

    def f2()= {
      f1 _
    }



    f2()()


    def f3() ={
      def f4(): Unit ={
        println("hello word")
      }

      f4 _
    }

    f3()()

    //todo 闭包
    def f5(i :Int) ={
      def f6(j:Int): Unit ={
        println(i+j)
      }

      f6 _
    }

    f5(5)(6)

    //todo 柯里化
    def f7(i :Int)(j :Int) ={
      println(s"i = ${i} j = ${j} ")
    }

    f7(3)(4)

    //todo 柯里化 分步调用
    val fff: Int => Unit = f7(6)
    fff(5)


    //todo 函数做参数传递
    def f8(f : ()=>Int): Int ={
      f() + 10
    }

    def f9(): Int ={
      12
    }

    println(f8(f9))

    //todo 匿名函数
    def f10 (f : ()=>Unit): Unit ={
      f()
    }
    f10(()=>{println(10)})


  }
}
