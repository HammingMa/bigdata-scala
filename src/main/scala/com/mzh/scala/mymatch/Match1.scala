package com.mzh.scala.mymatch

object Match1 {

  def main(args: Array[String]): Unit = {

    val oper = '+'
    val n1 = 20
    val n2 = 10
    var res = 0

    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case _ => println("oper error")
    }

    println(res)

    //守卫
    for(ch <- "+-3!"){
      var sign = 0
      var digit = 0

      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if ch.toString.equals("3") => digit =3
        case _ => sign = 2
      }
      println(ch + " " + sign + " " + digit)
    }

    for(ch <- "+-3!"){
      var sign = 0
      var digit = 0

      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ => sign = 2
        case _ => sign = 3
      }
      println(ch + " " + sign + " " + digit)
    }

    for(ch <- "+-3!"){
      var sign = 0
      var digit = 0

      ch match {
        case _ => sign = 3
        case '+' => sign = 1
        case '-' => sign = -1
      }
      println(ch + " " + sign + " " + digit)
    }

    //使用变量
    val ch = 'V'

    ch match {
      case '+' => println("ok~")
      case myChar => println("ok~"+ myChar)
      case _ => println("ok~~")
    }


    val a=5

    val obj = if(a == 1) 1
    else if(a == 2) "2"
    else if(a == 3) BigInt(3)
    else if(a == 4) Map("aa" -> 1)
    else if(a == 5) Map(1 -> "aa")
    else if(a == 6) Array(1, 2, 3)
    else if(a == 7) Array("aa", 1)
    else if(a == 8) Array("aa")

    val result = obj match {
      case a : Int => a
      case b : Map[String, Int] => "对象是一个字符串-数字的Map集合"
      case c : Map[Int, String] => "对象是一个数字-字符串的Map集合"
      case d : Array[String] => "对象是一个字符串数组"
      case e : Array[Int] => "对象是一个数字数组"
      case f : BigInt => Int.MaxValue
      case _ => "啥也不是"
    }
    println(result)

    //类型匹配

//    val obj1 = 10
//
//    val result1 = obj1 match {
//      case a : Int => a
//      case map: Map[String,Int] => "Map集合"
//      case _ => "啥也不是"
//    }
//    println(result1)

    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1))) {

      val result = arr match {
          case Array(0) => "0"
          case Array(x, y) => x + "=" + y
          case Array(0, _*) => "以0开头和数组"
          case _ => "什么集合都不是"
        }
        println("result = " + result)
      }

    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0" //
        case x :: y :: Nil => x + " " + y
        case 0 :: tail => "0 ..."
        case _ => "something else"
      }
      println(result)

    }


    // 元组匹配
    for (pair <- Array((0, 1), (1, 0), (2, 1),(1,0,2))) {
      val result = pair match {
        case (0, _) => "0 ..."
        case (y, 0) => y
        case (a, b) => (b, a)
        case _ => "other"
      }
      println(result)

    }


    //对象匹配
    object Square {
      def unapply(d: Double): Option[Double] = Some(math.sqrt(d))

      def apply(z : Double): Double = z * z
    }

    val d = 35.0
    d match {
      case Square(n) => println(n)
      case _ => println("noting matched")
    }

    //变量声明中的模式匹配
    val (x,y) = (1,2)
    val (q,r) = BigInt(3)/%2
    println(x)
    println(y)
    println(q)
    println(r)

    val arr = Array(1,2,3,4,5)

    val Array(f,s,_*) = arr
    println(f + " " + s)


    //for 循环的模式匹配

    val map: Map[String, Int] = Map("a"->1,"b"->2,"c"->3)
    for ((x,y) <- map) {
      println(x + "->"+y)
    }

    for ((x,2) <- map) {
      println(x + "->"+2)
    }

    for ((x,y) <- map if y ==3 ) {
      println(x + "->"+y)
    }
  }
}
