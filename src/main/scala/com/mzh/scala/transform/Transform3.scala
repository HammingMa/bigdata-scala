package com.mzh.scala.transform

object Transform {
  def main(args: Array[String]): Unit = {

    val u = new User
    u.login()
    u.logout()

  }


  implicit class Person(user : User){
    def logout(): Unit ={

    }
  }

}

class User{
  def login (): Unit ={

  }
}