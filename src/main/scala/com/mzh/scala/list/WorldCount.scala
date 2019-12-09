package com.mzh.scala.list

import scala.collection.mutable.ArrayOps

object WorldCount {
  def main(args: Array[String]): Unit = {
    val lineList = List(("hello scala world",4),("hello world",3),("hello hadoop",2),("hello hbase",1))

    val flatMapList: List[(String, Int)] = lineList.flatMap(t => {
      val line: String = t._1
      val words = line.split(" ")
      words.map(w => (w, t._2))
    })

    val groupWordMap: Map[String, List[(String, Int)]] = flatMapList.groupBy(t => t._1)

    val wordToSumMap: Map[String, Int] = groupWordMap.map(t => {
      val count: Int = t._2.map(t => t._2).sum
      (t._1, count)
    })

    val wordSortMap: List[(String, Int)] = wordToSumMap.toList.sortWith((left,right)=>left._2>right._2)

    val resultMap: List[(String, Int)] = wordSortMap.take(3)
    
    println(resultMap)

    val mapValuesMap: Map[String, Int] = groupWordMap.mapValues( l => l.map(t => t._2).sum)
    println(mapValuesMap)
  }
}
