package com.example.test;

/**
 * 匿名内部类
 */
public class Singleton3 {
    private static class getInstance{
        public static  Singleton3 s3 = new Singleton3();
    }

    private Singleton3 (){}

    public static Singleton3 i (){
        return getInstance.s3;
    }
}
