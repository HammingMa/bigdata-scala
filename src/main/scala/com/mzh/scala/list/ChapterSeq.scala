package com.mzh.scala.list

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object ChapterSeq {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1,2,3,4)
    val list1: List[Int] = List(5,6,7,8)
    // println(list.length)

    // println(list.mkString(","))

    /*
    for(l <- list){
      println(l)
    }
     */

    /*
    val list2: List[Int] = list.+:(5)
    println(list.mkString(","))
    println(list2.mkString(","))
     */

    /*
    val list3: List[Int] = list.::(5)
    println(list.mkString(","))
    println(list3.mkString(","))
     */

    /*
    val list4: List[Int] = 5 :: 6 :: 7 :: list
    println(list.mkString(","))
    println(list4.mkString(","))
     */

    /*
    val list5: List[Int] = list++list1
    println(list.mkString(","))
    println(list5.mkString(","))
     */

    /*
    val list6: List[Any] = 5::list1::list
    val list7: List[Int] = 5::list1:::list
    println(list.mkString(","))
    println(list6)
    println(list7)
     */

    /*
    val list8: List[Int] = list.updated(1,10)
    println(list.mkString(","))
    println(list8.mkString(","))
     */

    /*
    println(List())
    println(Nil)
    println(1::2::3::Nil)
     */


    val mlist: ListBuffer[Int] = ListBuffer(9,8,7,6)

    // println(mlist.length)
    // println(mlist.mkString(","))
    // mlist.foreach(println)

    /*
    println(mlist.head)
    println(mlist.tail)

    println(mlist.last)
    println(mlist.init)
     */

    /*
    mlist(0)=10
    println(mlist.mkString(","))
     */

    /*
    val mlist2: ListBuffer[Int] = mlist.drop(3)
    println(mlist.mkString(","))
    println(mlist2.mkString(","))
     */

    /*
    mlist.insert(2,10)
    println(mlist.mkString(","))
     */

    /*
    val mlist3: ListBuffer[Int] = mlist.updated(1,2)
    println(mlist.mkString(","))
    println(mlist3.mkString(","))
     */

    val q: mutable.Queue[Int] = mutable.Queue(1,2,3,4)

    println(q)
    q.enqueue(10)
    println(q)
    val i: Int = q.dequeue()
    println(i)
    println(q)




  }
}
