package com.mzh.scala.list

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Array1 {
  def main(args: Array[String]): Unit = {
    val ints: Array[Int] = Array(1,2,3,5)

    //println(ints(0))

    //println(ints.length)

    //ints.update(1,7)
    //println(ints.mkString(","))

    /*
    val ints1: Array[Int] = ints:+5
    println(ints1.mkString(","))

    println(ints==ints1)
    */

    /*
    for(i <- ints){
      println(i)
    }
    */

    /*
    def println11(i:Int): Unit ={
      println(i)
    }

    ints.foreach(println11)
     */

    /*
    ints.foreach((i:Int)=>{println(i)})
    ints.foreach((i:Int)=>println(i))
    ints.foreach(i=>println(i))
    ints.foreach(println)
     */

    val buffer: ArrayBuffer[Int] = ArrayBuffer(5,6,7,8)

    /*
    println(buffer.mkString(","))
    println(buffer.length)
     */

    /*
    buffer.insert(1,9)
    println(buffer.mkString(","))
     */

    // buffer.foreach(println)

    // buffer(0)=0

    val buffer1: ArrayBuffer[Int] = buffer+=5
    println(buffer.mkString(","))
    println(buffer==buffer1)

    val array: Array[Int] = buffer.toArray

    val buffer2: mutable.Buffer[Int] = ints.toBuffer

    for (b <- buffer){
      println(b)
    }


  }
}
