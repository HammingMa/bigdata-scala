package com.mzh.scala.list

import scala.collection.mutable

object ChapterSet {
  def main(args: Array[String]): Unit = {
    val set: Set[Int] = Set(1,2,3,4,1,5)

    // println(set.mkString(","))

    // println(set + 9)

    //println(set-4)
    //println(set-9)

    // set.foreach(println)

    /*
    for (elem <- set) {
      println(elem)
    }
     */


    val mset: mutable.Set[Int] = mutable.Set(5,6,7,8)

    /*
    val mset2: mutable.Set[Int] = mset.drop(2)
    println(mset.mkString(","))
    println(mset2.mkString(","))
     */

    val bool: Boolean = mset(1)
    println(bool)
  }
}
