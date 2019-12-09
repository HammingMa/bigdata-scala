package com.mzh.scala.list

import scala.collection.mutable

object MethodFold {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)


    //折叠可以对集合进行简化，获取一条最终的结果
    //fold方法有两部分参数，第一部分为集合外部的数据
    //第二部的参数表示对数据进行的逻辑处理


    val r1: Int = list.fold(10)(_+_)
    println(r1)

    val r2: Int = list.fold(100)(_-_)
    println(r2)

    val r3: Int = list.foldLeft(100)(_-_)
    println(r3)

    val r4: Int = list.foldRight(10)(_-_)
    println(r4)

    //将两个map进行相同的key值相加
    val map1: mutable.Map[String, Int] = mutable.Map("a"->1,"b"->3,"c"->5)
    val map2: mutable.Map[String, Int] = mutable.Map("a"->2,"b"->6,"d"->3)

    val resultMap: mutable.Map[String, Int] = map1.foldLeft(map2)((map, t) => {
      map(t._1) = map.getOrElse(t._1, 0) + t._2
      map
    })
    println(resultMap)

  }
}
