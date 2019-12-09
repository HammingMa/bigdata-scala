package com.mzh.scala.transform

object Transform1 {
  def main(args: Array[String]): Unit = {

    implicit def transform(mysql : Mysql): Operater ={
      new Operater
    }


    val mysql = new Mysql

    mysql.select()
    mysql.delete()
  }
}

class Operater{
  def delete(): Unit ={

  }
}

class Mysql {
  def select (): Unit ={

  }
}
