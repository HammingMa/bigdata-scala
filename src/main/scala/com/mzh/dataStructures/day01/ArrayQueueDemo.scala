package com.mzh.dataStructures.day01

import com.sun.tools.corba.se.idl.constExpr.And
import sun.jvm.hotspot.debugger.SymbolLookup

import scala.io.StdIn

object ArrayQueueDemo {
  def main(args: Array[String]): Unit = {

   val queue = new  ArrayQueue(3)

    var flag :Boolean = true
    while(flag){
      println("请选择菜单：")
      println("show:显示队列")
      println("add:添加数据")
      println("get:获取数据")
      println("peek:查看队头")
      println("exit:推出程序")
      val key: String = StdIn.readLine()

      key match {
        case "show" => queue.showQueue()
        case "add" => println("请输入数据")
                      val num: Int = StdIn.readInt()
                      queue.addqueue(num)
        case "get" => val res = queue.getQueue()
          if(res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception])
          }else{
            println(res.asInstanceOf[Int])
          }
        case "peek" => val res = queue.peek()
          if(res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception])
          }else{
            println(res.asInstanceOf[Int])
          }
        case "exit" => flag = false
        case _ => println("输入代码有误请重新输入")
      }
    }

  }
}

class ArrayQueue(arrMaxSize : Int){
  val maxSize= arrMaxSize
  val arr = new Array[Int](maxSize)

  //队头初始化为-1 ，表示队列的头，不包含头元素，即指向队列的第一个元素的前一个位置
  var front :Int = -1
  //队尾 初始化为-1，表示队列额尾部，包含队列的最后一个元素
  var rear : Int = -1

  //判空 头尾相等 则为空
  def isEmpty(): Boolean ={
    front==rear
  }

  //判满 队尾等于 maxSize-1
  def isFull(): Boolean ={
    rear == (maxSize - 1)
  }

  //入队
  def addqueue(num :Int): Unit ={
    if (isFull()){
      println("队列已满，不能添加数据")
      return
    }

    rear += 1
    arr(rear) =num

  }

  //显示
  def showQueue(): Unit ={
    if(isEmpty()){
      println("队列为空")
      return
    }

    for (i<- front+1 to rear) {
      printf("arr(%d)=%d ",i,arr(i))
    }
    println()

  }

  //出队 获取数据
  def getQueue(): Any ={
    if(isEmpty()){
      return new Exception("队列为空，不能获取数据")
    }
    front+=1
    arr(front)
  }

  //查看对头
  def peek(): Any ={
    if(isEmpty()){
      return new Exception("队列为空，不能查看数据")
    }
    arr(front+1)
  }

}
