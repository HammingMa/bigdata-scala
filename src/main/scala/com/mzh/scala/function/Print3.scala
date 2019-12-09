package com.mzh.scala.function

object Print3 {
  def main(args: Array[String]): Unit = {
    val name = "张三"
    val age =1
    val url = "www.zhangsan.com"

    println("name="+name+",age="+age+",url="+url+"")

    printf("name=%s,age=%d,url=%s \n",name,age,url)


    //插值输出
    println(s"name=${name},age=${age},url=${url}")

    //格式化输出
    println(f"name=${name},age=${age}%.2f,url=${url}")

    //原样输出
    println(raw"name=${name},age=${age}%.2f,url=${url} \n")

  }
}
