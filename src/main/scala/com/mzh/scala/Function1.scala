package com.mzh.scala

object Function1 {
  def main(args: Array[String]): Unit = {
    def test(agrs : String*): Unit ={
      println(agrs)
    }


    test("zhangsan","lisi")

    test()

    def test1(name :String, age :Int=10): Unit ={
      println(s"name = ${name} , age = ${age}")
    }


    test1("zhangsan")

    test1("lisi",20)

    test1(name="wangwu")

    def test2(name1 :String = "lisi",name2 :String): Unit ={
      println(s"name1 = ${name1} , name2 =${name2} ")
    }


    test2(name2="wangwu")

  }
}
