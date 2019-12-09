package com.mzh.day02

object HanoiTower {
  def main(args: Array[String]): Unit = {
    hanoiTower(3,'A','B','C')
  }

  def hanoiTower(nums : Int,a : Char,b : Char,c : Char): Unit ={

    if(nums==1){
      println(s"第${nums}盘 ${a}塔 --> ${c}塔")
    }else{
      hanoiTower(nums-1,a,c,b)
      println(s"第${nums}盘 ${a}塔 --> ${b}塔")
      hanoiTower(nums-1,b,a,c)
      //println(s"第${nums}盘 ${b}塔 --> ${c}塔")
    }

  }
}
