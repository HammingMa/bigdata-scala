package com.mzh.scala.list

import scala.collection.mutable

object chapterMap {
  def main(args: Array[String]): Unit = {

    val map: Map[String, Int] = Map("a"->1,"b"->2,"c"->3)
    println(map.mkString(","))

    //println(map+("d"->4))
    //println(map+("a"->100))

    //val map2: Map[String, Int] = map.updated("c" , 999)
    //println(map.mkString(","))
    //println(map2.mkString(","))

    //val map3: Map[String, Int] = map-"b"
    //println(map.mkString(","))
    //println(map3.mkString(","))

    println(map.get("b"))
    println(map.get("b").get)
    println(map.get("f").getOrElse(0))

    val mmap: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->2,"c"->3)


  }
}
