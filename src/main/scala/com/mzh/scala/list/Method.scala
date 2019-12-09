package com.mzh.scala.list

object Method {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,4,3,7,1,3)

    //求和
    println(list.sum)
    //最大值
    println(list.max)
    //最小值
    println(list.min)
    //乘机
    println(list.product)
    //翻转
    println(list.reverse)

    //分组
    val intToInts: Map[Int, List[Int]] = list.groupBy(x=>x)
    println(intToInts.mkString(","))
    //奇偶分组
    val groupByMap: Map[Int, List[Int]] = list.groupBy(x=>x%2)
    println(groupByMap.mkString(","))
    //字符第二位分组
    val strList1 = List("23","11","13","25","35","21")
    val stringToStrings: Map[String, List[String]] = strList1.groupBy(x=>x.substring(1))
    println(stringToStrings.mkString(","))

    //排序
    println(list.sortBy(x => x))
    //字符串第二位排序
    val strList = List("19","82","37","46","91","73","64","55","28")
    val strListSort: List[String] = strList.sortBy(x =>x.substring(1))
    println(strListSort.mkString(","))

    //sortWith 升序
    val ints: List[Int] = list.sortWith((x,y)=>x<y)
    println(ints.mkString(","))
    //降序
    val ints1: List[Int] = list.sortWith((x,y)=>x>y)
    println(ints1.mkString(","))
    //字符串第二位升序
    val strings1: List[String] = strList.sortWith((left,right)=> {
      left.substring(1)>right.substring(1)
    })
    println(strings1.mkString(","))


    //迭代
    for (elem <- list.iterator) {
      println(elem)
    }

    //map映射
    val tuples: List[(Int, Int)] = list.map(x=>(x,1))
    val intToTuples: Map[Int, List[(Int, Int)]] = tuples.groupBy(t => t._1)
    val wc: Map[Int, Int] = intToTuples.map(t => (t._1,t._2.size))
    println(wc.mkString(","))

    //取前几名
    println(list.take(2))

    //word count
    //对集合中的单词出现的次数进行统计，并且以出现的次数排序，取前三名
    val words = List("hello","hadoop","hello","world","scala","hive","kafka","hbase","hadoop","hello","hive","hive")

    val wordCount: Map[String, Int] = words.map(w => (w,1)).groupBy(t => t._1).map(t => (t._1,t._2.size))
    val wordCountTuples: List[(String, Int)] = wordCount.toList.sortWith((x,y) => x._2>y._2).take(3)
    println(wordCountTuples.mkString(","))


    //扁平化flatmap
    val lines: List[String] = List("hello hadoop","hello world","hello hadoop","scala spark")

    val flatMapList: List[String] = lines.flatMap(x => x.split(" "))

    println(lines.mkString(","))
    println(flatMapList.mkString(","))

    val lineWordCount: List[(String, Int)] = flatMapList.map(w => (w,1)).groupBy(t => t._1).map(t => (t._1,t._2.size)).toList.sortWith((x,y)=> x._2>y._2).take(3)
    println(lineWordCount.mkString(","))

  }
}
