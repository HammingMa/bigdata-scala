package com.mzh.dataStructures.day01

import scala.collection.mutable.ArrayBuffer

object SparseArrayDemo {
  def main(args: Array[String]): Unit = {
    //五子棋棋盘的保存，压缩，稀疏矩阵

    val rows: Int = 11
    val cols: Int = 11

    //初始化棋盘
    val chessMap1: Array[Array[Int]] = Array.ofDim[Int](rows,cols)
    chessMap1(1)(2) = 1
    chessMap1(2)(3) = 2
    chessMap1(5)(6) = 1
    chessMap1(4)(2) = 2


    println("原始棋盘")
    for (elem <- chessMap1) {
      println(elem.mkString(" "))
    }

    //稀疏矩阵存储
    val sparseArray: ArrayBuffer[Node] = ArrayBuffer()

    sparseArray.append(new Node(rows,cols,0))

    var cnt = 0;
    for (row <- 0 until chessMap1.length) {
      for (col <- 0 until chessMap1(row).length) {
        if(chessMap1(row)(col)!= 0){
          sparseArray.append(new Node(row,col,chessMap1(row)(col)))
          cnt += 1
        }
      }
    }

    //重新设置第0个元素
    sparseArray(0) = new Node(rows,cols,cnt)
    println("压缩后的棋盘")
    for (node <- sparseArray) {
      println(node.row + " " + node.col + " " + node.value)
    }


    //将稀疏数组恢复成原始的棋盘
    val rows2: Int = sparseArray(0).row
    val cols2: Int = sparseArray(0).col

    val chessMap2: Array[Array[Int]] = Array.ofDim[Int](rows2,cols2)

    for (node <- sparseArray.tail) {
      chessMap2(node.row)(node.col) = node.value
    }

    println("恢复后的棋盘")
    for (elem <- chessMap2) {
      println(elem.mkString(" "))
    }

  }

  class Node (val row :Int,val col :Int,val  value :Int )
}
