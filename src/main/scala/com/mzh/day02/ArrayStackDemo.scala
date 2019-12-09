package com.mzh.day02

import scala.io.StdIn

object ArrayStackDemo {
  def main(args: Array[String]): Unit = {
    val stack : ArrayStack = new ArrayStack(4)

    var flag = true
    while(flag){
      println()
      println("请选择操作")
      println("push:入栈")
      println("list:遍历栈")
      println("pop:出栈")
      println("peek:查看栈顶")
      println("exit:退出")

      val key: String = StdIn.readLine()

      key match {
        case "push" => println("请输入一个数")
          val num: Int = StdIn.readInt()
          stack.push(num)
        case "list" => stack.list()
        case "pop" => val res = stack.pop()
          if(res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            println(res.asInstanceOf[Int])
          }
        case "peek" => val res = stack.peek()
          if(res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            println(res.asInstanceOf[Int])
          }
        case "exit" => flag = false
        case _ => println("输入有误请重新输入")
      }

    }

  }
}

class ArrayStack(arrMaxsize : Int){

  val maxSize = arrMaxsize
  var top = -1
  val arr: Array[Int] = new Array[Int](maxSize)

  //栈空判断
  def isEmpyt(): Boolean ={
    top == -1
  }

  //栈满判断
  def isFull(): Boolean ={
    top == maxSize -1
  }

  //入栈
  def push(num : Int): Unit ={
    if(isFull()){
      println("栈满不能入栈")
      return
    }

    top += 1
    arr(top)=num
  }

  //遍历栈
  def list(): Unit ={
    if(isEmpyt()){
      println("栈空不能遍历")
      return
    }
    for (i<- 0 to top reverse) {
      print("arr("+i +")=" +arr(i)+" ")
    }
    println()
  }

  //出栈
  def pop(): Any ={
    if(isEmpyt()){
      return new Exception("栈空，不能出栈")
    }

    val res = arr(top)
    top -= 1
    return res

  }

  //查看栈顶
  def peek(): Any ={
    if(isEmpyt()){
      return new Exception("栈空，不能查看栈顶")
    }

     return arr(top)

  }

}


