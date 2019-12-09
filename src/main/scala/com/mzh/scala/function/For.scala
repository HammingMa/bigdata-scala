package com.mzh.scala.function

import scala.collection.immutable
import scala.util.control.Breaks.{break, breakable}

object For {
  def main(args: Array[String]): Unit = {

    for(i <- 1 to 5){
      println(s"i = ${i}")
    }

    for (j <- 1 until 5){
      println(s"j = ${j}")
    }


    //TODO  Range
    for(i <- Range(1,5)){
      println(i)
    }

    //todo 加步长

    for (i <- Range(1,10,2)){
      println(i)
    }


    //todo 一层for 循环九层妖塔
    for(i <- Range(1,20,2)){
      println(" "*((20-i)/2) + "*"*i)
    }


    //todo for 加变量
    for(i <- Range(1,20,2); j=(20-i)/2 ){
      println(" "*j+"*"*i)
    }

    //todo for 换行
    for{i <- Range(1,20,2)
      j=(20-i)/2
    }{
      println(" "*j+"*"*i)
    }


    //todo for 守卫
    for (i <- 1 to 10 if i%2==1){
      println(i)
    }

    //todo for 返回值
    val res: Unit = for(i <- 1 to 20){
      println(i)
    }
    println(res)

    //todo for yield
     val ints: immutable.IndexedSeq[Int] = for(i <- 1 to 10) yield i * 2

    println(ints)

    //todo for 嵌套循环
    for(i <- 1 to 3;j <- 1 until 3){
      println(s" i = ${i} , j = ${j}")
    }

    //todo for 终止循环
//    Breaks.breakable{
//      for(i <- 1 to 10){
//        if(i==5){
//          Breaks.break()
//        }
//        println(i)
//      }
//    }
//    println("循环结束")

    //todo 简化
    breakable{
      for(i <- 1 to 10){
        if(i==5){
          break()
        }
        println(i)
      }
    }
    println("循环结束")

  }
}
