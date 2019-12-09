package com.mzh.day02
import scala.util.control.Breaks._

//josephu 问题 丢手绢问题
object CircleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val boys = new CircleLinkedList()
    boys.addBoy(5)
    boys.list()
    boys.countBoy2(2,2,5)
  }
}

class CircleLinkedList{
  var first :Boy = null

  def isEmpty(): Boolean ={
    first == null
  }

  //小孩出圈
  def countBoy2(startNums :Int,countNums :Int, boyNums :Int): Unit ={
    if(startNums>boyNums || first ==null || startNums<=0){
      println("输入参数有误，不能玩游戏")
      return
    }

    var helper :Boy = first
    breakable{
      while (true){
        if(helper.next == first){
          break()
        }
        helper = helper.next
      }
    }


    for (i<- 0 until startNums - 1) {
      helper = helper.next
    }

    breakable{
      while (true){
        for (i <- 0 until countNums - 1) {
          helper = helper.next
        }

        println(s"${helper.next.no}号小孩出圈")
        helper.next = helper.next.next

        if(helper.next == helper){
          break()
        }

      }
    }

    println(s"${helper.no}小孩是幸运者")


  }




  //小孩出圈
  def countBoy(startNums :Int,countNums :Int, boyNums :Int): Unit ={
    if(startNums>boyNums || first ==null || startNums<=0){
      println("输入参数有误，不能玩游戏")
      return
    }

    var helper :Boy = first
    breakable{
      while (true){
        if(helper.next == first){
          break()
        }
        helper = helper.next
      }
    }


    for (i<- 0 until startNums - 1) {
      first = first.next
      helper = helper.next
    }

    breakable{
      while (true){
        for (i <- 0 until countNums - 1) {
          first = first.next
          helper = helper.next
        }

        println(s"${first.no}号小孩出圈")
        first = first.next
        helper.next = first

        if(first == helper){
          break()
        }

      }
    }

    println(s"${helper.no}小孩是幸运者")


  }

  def addBoy(boyNums :Int): Unit ={
    var curBoy :Boy = null

    for (i <- 1 to boyNums) {
      var boy :Boy = new Boy(i)

      if(isEmpty()){
        first = boy
        first.next = first
        curBoy = first
      }

      curBoy.next=boy
      boy.next = first
      curBoy = curBoy.next
    }

  }

  def list(): Unit ={
    if(isEmpty()){
      println("链表为空无能遍历")
    }

    var curBoy :Boy = first
    var flag :Boolean = true
    while (flag){
      print(curBoy.no + " ")

      if(curBoy.next == first){
        println()
        flag = false
      }
      curBoy = curBoy.next
    }
  }

}

class Boy(bNo :Int){
  val no :Int  = bNo
  var next :Boy = null
}
