package com.example.test;

/**
 * 单例模式的饿汉模式
 * 特点：在类加载的时候实例就会被创建，实例在整个项目周期里都有，
 *      好处是类加载就会创建一个实例，避免了多线程创建多个实例的问题，避免了线程的同步问题
 *      缺点：如果类加载完后没用这个实例，内存就浪费了
 */
public class Singleton1 {
    //1.私有化构造方法
    private Singleton1 (){}

    private static Singleton1 s1 = new Singleton1();

    public static Singleton1 getInstance(){
        return s1;
    }

}
