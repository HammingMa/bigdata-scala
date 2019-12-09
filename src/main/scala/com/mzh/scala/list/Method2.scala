package com.mzh.scala.list

object Method2 {
  def main(args: Array[String]): Unit = {
    //过滤
    val ints = List(1,2,3,4)
    val ints1: List[Int] = ints.filter(x => x%2==0)
    println(ints1.mkString(","))

    //拉链 ZIP
    val list1 = List(1,2,4,5,7)
    val list2 = List(6,3,7,5)
    val tuples: List[(Int, Int)] = list1.zip(list2)
    println(tuples)

    //集合并集
    val unionList: List[Int] = list1.union(list2)
    println(unionList)

    //集合交集
    val intersectList: List[Int] = list1.intersect(list2)
    println(intersectList)

    //集合差集
    val diffList: List[Int] = list1.diff(list2)
    println(diffList)

  }
}
