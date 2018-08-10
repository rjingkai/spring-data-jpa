package com.example.test;

/**
 * 懒汉模式：
 *  一般是用到的时候才去实例化，但是没有考虑线程安全
 */
public class Singleton2 {
   private static Singleton2 s2 = null;

   private Singleton2 (){}

   public static Singleton2 getInstance(){
       if (s2 == null){
           s2 = new Singleton2();
       }
       return s2;
   }
}
