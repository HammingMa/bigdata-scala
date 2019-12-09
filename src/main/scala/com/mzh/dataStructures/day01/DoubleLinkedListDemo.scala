package com.mzh.dataStructures.day01

import scala.util.control.Breaks.{break, breakable}

object DoubleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val heros: DoubleLinkedList = new DoubleLinkedList()

    val node1 = new HeroNode2(1,"宋江","及时雨")
    val node2 = new HeroNode2(2,"卢俊义","浑江龙")
    val node3 = new HeroNode2(3,"吴用","智多星")
    val node4 = new HeroNode2(4,"林冲","豹子头")
    val node5 = new HeroNode2(5,"孙二娘","母夜叉")

    heros.add(node1)
    heros.add(node2)
    heros.add(node3)
    heros.add(node4)
    heros.add(node5)

    println("初始化的双链表")
    heros.list()

    val node6 = new HeroNode2(2,"卢俊义","玉麒麟")
    heros.update(node6)
    println("修改后的双联表")
    heros.list()



    heros.del(1)
    heros.del(5)
    println("删除1和5后")
    heros.list()

    heros.del(2)
    heros.del(3)
    heros.del(4)
    heros.del(5)
    heros.list()

  }
}

class DoubleLinkedList{
  val head = new HeroNode2(-1,null,null)

  //添加
  def add(heroNode : HeroNode2): Unit ={
    var tmp = head

    var flag = true
    while(flag){
      if(tmp.next != null){
        tmp = tmp.next
      }else{
        tmp.next = heroNode
        heroNode.pre = tmp
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
  def update(node :HeroNode2): Unit ={
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

  //删除双向链表
  def del(no :Int ): Unit ={

    if(isEmpty()){
      println("链表为空，不能删除")
      return
    }

    var tmp = head.next

    var flag = false
    breakable{
      while(true){
        if(tmp.no == no ){
          flag = true
          break()
        }

        if(tmp.next== null){
          break()
        }

        tmp = tmp.next
      }
    }

    if(flag){

      tmp.pre.next = tmp.next
      if(tmp.next != null){
        tmp.next.pre =tmp.pre
      }


    }else{
      println(s"要删除的no为${no}的英雄不存在")
    }

  }
}

class HeroNode2(val hNo :Int, val hName :String,val hNickName :String) {
  val no = hNo
  var name = hName
  var nickName = hNickName

  var next: HeroNode2 = null
  var pre: HeroNode2= null

  override def toString: String = {
    s"(no=${no} , name=${name} , nickName=${nickName})"
  }
}
