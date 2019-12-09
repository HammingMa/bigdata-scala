package com.mzh.scala.function

object PartialFunction1 {
  def main(args: Array[String]): Unit = {

    val list = List(1,2,3,4,"abc")

    val f1: PartialFunction[Any, Int] = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int] + 1
      }

    }

    val res1: List[Int] = list.collect(f1)
    println(res1)

    def f2 : PartialFunction[Any,Int]= {
      case a : Int => a + 1
    }

    val res2: List[Int] = list.collect(f2)

    println(res2)

    val res3: List[Int] = list.collect{case i:Int => i +1}

    println(res3)

    val res4: List[String] = list.map {
      case a => a + "xxxx"
    }
    println(res4)

  }
}
