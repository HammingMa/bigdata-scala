package com.mzh.day02

//在内存的存储雇员信息  使用hashtable

object HashTableDemo {
  def main(args: Array[String]): Unit = {
    val emp1 : Emp = new Emp(5,"aa")
    val emp2 : Emp = new Emp(4,"bb")
    val emp3 : Emp = new Emp(3,"cc")
    val emp4 : Emp = new Emp(2,"dd")
    val emp5 : Emp = new Emp(1,"ee")
    val emp6 : Emp = new Emp(0,"ff")
    val emp7 : Emp = new Emp(14,"gg")
    val emp8 : Emp = new Emp(25,"hh")
    val emp9 : Emp = new Emp(13,"ii")
    val emp10 : Emp = new Emp(17,"mm")
    val emp11 : Emp = new Emp(27,"nn")

    val emps = new HashTable(4)

    emps.addEmp(emp6)
    emps.addEmp(emp7)
    emps.addEmp(emp8)
    emps.addEmp(emp9)
    emps.addEmp(emp10)
    emps.addEmp(emp11)
    emps.addEmp(emp1)
    emps.addEmp(emp2)
    emps.addEmp(emp3)
    emps.addEmp(emp4)
    emps.addEmp(emp5)

    emps.list()

    emps.findEmpByNo(4)

    emps.findEmpByNo(100)



  }
}

class HashTable(hSize : Int){
  val size = hSize

  val empLinedListArr = new Array[LinkedList](size)

  for (i <- 0 until size) {
    empLinedListArr(i) = new LinkedList()
  }

  def hash(no : Int): Int ={
    return no%size
  }

  def addEmp(emp: Emp): Unit ={
    val i : Int = hash(emp.no)
    //empLinedListArr(i).add(emp)
    empLinedListArr(i).addOrderNo(emp)
  }

  def list(): Unit ={
    for (i <- 0 until size) {
      print("第"+i+"条链表的情况：" )
      empLinedListArr(i).list()
    }
  }

  def findEmpByNo(no : Int): Unit = {
    val i : Int = hash(no)

    empLinedListArr(i).findEmpByNo(no)
  }
}

class LinkedList{
  var head : Emp = null

  def isEmpty(): Boolean ={
    head == null
  }

  def add(emp : Emp): Unit ={
    if(isEmpty()){
      head = emp
      return
    }
    var tmp = head
    while (tmp.next != null){
      tmp = tmp.next
    }
    tmp.next = emp
  }

  def addOrderNo(emp : Emp): Unit ={
    if(isEmpty()){
      head = emp
      return
    }

    if(head.no >emp.no){
      emp.next = head
      head = emp
      return
    }

    var tmp = head


    while (tmp.next!=null && tmp.next.no <= emp.no){
      tmp = tmp.next
    }
    if(tmp.next == null){
      tmp.next = emp
    }else{
      emp.next= tmp.next
      tmp.next = emp
    }
  }


  def list(): Unit ={
    if(isEmpty()){
      println("链表为空")
    }

    var tmp = head
    while (tmp != null){
      print(tmp + " --> ")
      tmp = tmp.next
    }
    println()
  }

  def findEmpByNo(no : Int): Unit ={
    if(isEmpty()){
      println("没有找到")
    }
    var tmp = head
    while (tmp!=null && tmp.no != no){
      tmp = tmp.next
    }
    if(tmp != null){
      println("查找结果"+tmp)
    }else{
      println("没有找到 no="+no)
    }

  }
}


class Emp(eNo : Int,eName : String){
  val no : Int = eNo
  var name : String = eName
  var next : Emp = null

  override def toString: String = {
    return s"(no:${no} name:${name})"
  }

}
