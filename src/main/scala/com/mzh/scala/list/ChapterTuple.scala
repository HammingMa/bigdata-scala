package com.mzh.scala.list

object ChapterTuple {
  def main(args: Array[String]): Unit = {
    val tuple: (String, Int, String) = ("zhangsan",3232,"vvvvvvv")

    // println(tuple._1)
    // println(tuple._2)
    // println(tuple._3)

    for (elem <- tuple.productIterator) {
      println(elem)
    }
    val tuple1: (Int, String) = (1,"lisi")

    val map: Map[String, Int] = Map(("zhangsan",10))

    map.foreach(t => println(t))

    map.foreach(println)

    map.foreach(t => println(t._1+"="+t._2))
  }
}
