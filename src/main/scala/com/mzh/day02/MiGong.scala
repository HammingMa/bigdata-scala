package com.mzh.day02

object MiGong {
  def main(args: Array[String]): Unit = {

    val map: Array[Array[Int]] = Array.ofDim[Int](8,7)

    //添加墙
    for (i <- 0 until 8) {
      map(i)(0) = 1
      map(i)(6) = 1
    }

    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }

    map(3)(1) = 1
    map(3)(2) = 1
    map(2)(2) = 1

    for (row <- map) {
      println(row.mkString(" "))
    }

    getWay(map,1,1)
    println("探测后的路径是")
    for (row <- map) {
      println(row.mkString(" "))
    }

  }

  // 0 未探测 1 墙 2 可以走 3 探测完未死路
  def getWay(map : Array[Array[Int]],i : Int,j : Int): Boolean ={
    if(map(6)(5)==2){
      return true
    }else{
      if(map(i)(j)==0){
        map(i)(j) = 2
        if(getWay(map,i+1,j)) {
          return true
        }else if(getWay(map,i,j+1)){
          return true
        }else if(getWay(map,i-1,j)){
          return true
        }else if(getWay(map,i,j-1)){
          return true
        }else{
          map(i)(j) = 3
          return false
        }
      }else{
        return false
      }
    }
  }

}
