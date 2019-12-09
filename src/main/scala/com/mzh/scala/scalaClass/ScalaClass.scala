package com.mzh.scala.scalaClass

object ScalaClass {
  def main(args: Array[String]): Unit = {

    def test[T  <: User ](t:T): Unit ={
      println(t)
    }

    def test2[T  >: User ](t:T): Unit ={
      println(t)
    }

    // <: 上线不可以穿父类
    //test(new Person())
    test(new User())
    test(new Student())

    // >: 父子类都可以传
    test2(new Person())
    test2(new User())
    test2(new Student())
  }

  val o : Other[User] = new Other[User]
  //和java一样声明 不变性，不能穿父子类
  //val o2 : Other[User] = new Other[Person]
  //val o3 : Other[User] = new Other[Student]

  // + 协变 可以声明子类，不能声明父类
  val o4 : Other2[User] = new Other2[User]
  val o5 : Other2[User] = new Other2[Student]
  //val o6 : Other2[User] = new Other2[Person]

  // - 逆变 可以声明父类，不可以声明子类
  val o7 : Other3[User] = new Other3[User]
  //val o8 : Other3[User] = new Other3[Student]
  val o9 : Other3[User] = new Other3[Person]
}

class Person{

}

class User extends Person{

}

class Student extends User{

}

class Other[T]{

}

class Other2[+T]{

}
class Other3[-T]{

}