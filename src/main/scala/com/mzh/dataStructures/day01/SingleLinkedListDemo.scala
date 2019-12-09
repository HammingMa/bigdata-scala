package com.mzh.dataStructures.day01

import util.control.Breaks._
import java.util



object SingleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val heros: SingleLinkedList = new SingleLinkedList()

    val node1 = new HeroNode(1,"宋江","及时雨")
    val node2 = new HeroNode(2,"卢俊义","浑江龙")
    val node3 = new HeroNode(3,"吴用","智多星")
    val node4 = new HeroNode(4,"林冲","豹子头")
    val node6 = new HeroNode(5,"孙二娘","母夜叉")


    heros.addOrderBy(node6)
    heros.addOrderBy(node2)
    heros.addOrderBy(node4)
    heros.addOrderBy(node1)
    heros.addOrderBy(node3)
    println("原始链表")
    heros.list()

    heros.reverse()
    println("翻转后的链表")
    heros.list()

    println("用栈逆序打印")
    heros.reversePrint()


    /*
    heros.add(node6)
    heros.add(node1)
    heros.add(node2)
    heros.add(node3)
    heros.add(node4)


    println("初始的英雄链表")
    heros.list()
    println()

    val node5 = new HeroNode(2,"卢俊义","玉麒麟")

    heros.update(node5)
    println("更新后的英雄链表")
    heros.list()

    println("删除1号后")
    heros.del(1)
    heros.list()

    println("删除5号后")
    heros.del(5)
    heros.list()

    println("删除不存在的后")
    heros.del(10)
    heros.list()

    println("删除3号后")
    heros.del(3)
    heros.list()

    heros.del(2)
    heros.del(4)
    heros.del(7)
     */
  }
}

class SingleLinkedList{
  val head :HeroNode = new HeroNode(-1,null,null)

  //添加
  def add(heroNode : HeroNode): Unit ={
    var tmp = head

    var flag = true
    while(flag){
      if(tmp.next != null){
        tmp = tmp.next
      }else{
        tmp.next = heroNode
        flag = false
      }
    }

  }

  //判空
  def isEmpty(): Boolean ={
    head.next == null
  }

  //遍历
  def list(): Unit ={
    if(isEmpty()){
      println("链表为空，不可以遍历")
    }
    var tmp = head.next

    breakable{
      while (true){
        if(tmp != null){
          print(tmp + " --> ")

        }else{
          break()
        }
        tmp = tmp.next
      }
    }
    println()

  }

  //修改
  def update(node :HeroNode): Unit ={
    if(isEmpty()){
      println("链表为空不能修改")
      return
    }

    var tmp = head.next

    var flag = true
    breakable{

      while(true){
        if(tmp.no == node.no){
          tmp.name = node.name
          tmp.nickName = node.nickName
          flag = false
          break()
        }

        if(tmp.next == null){
          break()
        }

        tmp = tmp.next

      }

      if(flag){
        println(s"没有找到节点编号为${node.no}的英雄")
      }
    }
  }

  //删除
  def del(no :Int): Unit ={

    if(isEmpty()){
      println("链表为空不能删除")
      return
    }

    var tmp = head

    var flag = false
    breakable {
      while (true) {
        if (tmp.next.no == no) {

          flag = true
          break()
        }

        if (tmp.next.next == null) {
          break()
        }
        tmp = tmp.next
      }
    }


      if(flag){

        tmp.next = tmp.next.next
      }else{
        println(s"要删除的no为${no}的英雄不存在")
      }

  }

  def addOrderBy(heroNode :HeroNode): Unit ={
    var tmp = head

    var flag = false
    breakable{
      while(true){
        if(tmp.next == null){
          flag = true
          break()
        }

        if(tmp.next.no == heroNode.no){
          flag = false
          break()
        }else if(tmp.next.no > heroNode.no){
          flag = true
          break()
        }
        tmp = tmp.next
      }
    }

    if(flag){
      heroNode.next = tmp.next
      tmp.next = heroNode
    }else{
      println(s"已经存在no为${heroNode.no}的英雄")
    }

  }

  //链表的翻转
  def reverse(): Unit ={
    //需要移动的节点
    var tmp = head.next
    //剩余的节点
    var tmp2 = head.next.next
    //把第一个节点的下一个节点置空
    tmp.next=null

    while(tmp2 != null){
      //tmp 后推一个 即 tmp = tmp  当前tmp的next 为翻转后 的节点，所以下推 不能区 tmp.next
      tmp = tmp2
      //tmp2下推
      tmp2 = tmp2.next

      tmp.next = head.next
      head.next = tmp

    }

  }

  //使用栈逆序打印单链表
  def reversePrint(): Unit ={
    if(isEmpty()){
      println("单链表为空不能打印")
    }

    val stack: util.Stack[HeroNode] = new util.Stack[HeroNode] ()

    var tmp = head.next
    var flag : Boolean = true
    while (flag){
      stack.push(tmp)
      if(tmp.next == null){
        flag = false
      }

      tmp = tmp.next
    }

    while(!stack.isEmpty){

      print(stack.pop() + " --> ")
    }


  }

}

class HeroNode(val hNo :Int, val hName :String,val hNickName :String) {
  val no = hNo
  var name = hName
  var nickName = hNickName

  var next :HeroNode = null

  override def toString: String = {
    s"(no=${no} , name=${name} , nickName=${nickName})"
  }
}
