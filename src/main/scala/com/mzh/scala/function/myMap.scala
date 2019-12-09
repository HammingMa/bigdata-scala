package com.mzh.scala.function

object myMap {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,"abc")

    val mapList: List[AnyVal] = list.map(any => {
      if (any.isInstanceOf[Int]) {
        any.asInstanceOf[Int] + 1
      }
    })
    println(mapList)
    val resultList: List[AnyVal] = mapList.filter(any => any.isInstanceOf[Int])

    println(resultList)


  }
}
