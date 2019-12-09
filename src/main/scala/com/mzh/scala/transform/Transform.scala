package com.mzh.scala.transform

object Transform {
  def main(args: Array[String]): Unit = {

    implicit def transform(d : Double): Int ={
      d.toInt
    }

    /*
    implicit def transform111(d : Double): Int ={
      d.toInt
    }
   */

    val i : Int = 5.0
  }
}
