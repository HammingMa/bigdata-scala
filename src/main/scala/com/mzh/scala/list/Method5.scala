package com.mzh.scala.list

import scala.collection.immutable
import scala.collection.parallel.immutable.ParSeq

object Method5 {
  def main(args: Array[String]): Unit = {

    //将集合any类型的集合打平
    val list: List[Any] = List(1,List(2,3),4,5,List(6,7,8),9,List(10))

    val resultList: List[Any] = list.flatMap((any) => {
      if (any.isInstanceOf[List[Int]]) {
        any.asInstanceOf[List[Int]]
      } else {
        List(any)
      }
    })
    println(resultList)

    //scan
    val ints = List(1,2,3,4)
    val scanList: List[Int] = ints.scan(10)(_-_)
    println(scanList)
    val scanLeftList: List[Int] = ints.scanLeft(10)(_-_)
    println(scanLeftList)
    val scanRightList: List[Int] = ints.scanRight(10)(_-_)
    println(scanRightList)


    //并行集合
    val list1: immutable.IndexedSeq[String] = (0 to 100).map{case _ => Thread.currentThread().getName}
    val list2: ParSeq[String] = (0 to 100).par.map{case _ => Thread.currentThread().getName}

    println(list1)
    println(list2)

  }



}
