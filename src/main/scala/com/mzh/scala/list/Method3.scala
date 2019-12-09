package com.mzh.scala.list

object Method3 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)

    //减少 化简 规约 reduce
    //数据减少，结果不减少
    //将集合的数据经过逻辑处理，变成一个结果，具体的结果需要参照逻辑处理
    val result: Int = list.reduce((left,right)=>{left+right})
    println(result)

    val result2: Int = list.reduce((left,right)=>left+right)
    println(result2)

    val result3: Int = list.reduce(_+_)
    println(result3)

    val result4: Int = list.reduce(_-_)
    println(result4)

    val result5: Int = list.reduceLeft(_-_)
    println(result5)

    val result6: Int = list.reduceRight(_-_)

    println(result6)
  }
}
