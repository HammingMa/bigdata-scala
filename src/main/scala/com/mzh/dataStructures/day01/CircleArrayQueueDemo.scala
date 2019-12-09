package com.mzh.dataStructures.day01



import scala.io.StdIn

object CircleArrayQueueDemo {

  def main(args: Array[String]): Unit = {

   val queue = new  CircleArrayQueue(3)

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
                      queue.addQueue(num)
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
      println()
    }

  }
}

class CircleArrayQueue(arrMaxSize : Int){
  val maxSize= arrMaxSize+1
  val arr = new Array[Int](maxSize)

  //队头初始化为0 ，表示队列的头，包含头元素，
  var front :Int = 0
  //队尾 初始化为0，表示队列额尾部，包不包含队列的最后一个元素即队尾的最后一个元素的下一个位置
  var rear : Int = 0

  //判空 头尾相等 则为空
  def isEmpty(): Boolean ={
    front==rear
  }

  //判满 队尾等于 maxSize-1
  def isFull(): Boolean ={
    (rear+1) % maxSize == front
  }

  //入队
  def addQueue(num :Int): Unit ={
    if (isFull()){
      println("队列已满，不能添加数据")
      return
    }

    arr(rear) =num
    rear = (rear + 1)%maxSize

  }

  //获取队列的元素的个数
  def size(): Int ={
    return (rear+maxSize-front)%maxSize
  }

  //显示
  def showQueue(): Unit ={
    if(isEmpty()){
      println("队列为空")
      return
    }

    for (i <- front until (front + size())) {
      printf("arr(%d)=%d ",i%maxSize,arr(i%maxSize))
    }
    println()

  }

  //出队 获取数据
  def getQueue(): Any ={
    if(isEmpty()){
      return new Exception("队列为空，不能获取数据")
    }

    val res = arr(front)
    front+=1
    return  res
  }

  //查看对头
  def peek(): Any ={
    if(isEmpty()){
      return new Exception("队列为空，不能查看数据")
    }
    arr(front)
  }

}
