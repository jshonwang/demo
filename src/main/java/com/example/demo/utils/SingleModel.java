package com.example.demo.utils;

/**
 * DCL 双重检查锁定 volatile保证可见性和禁止指令重排序  但其实可见性 synchronized也可以保证了  并且还可以保证原子性。当然
 * 缺点是容易阻塞  volatile只能对变量进行修饰  但synchronized可以对变量  代码快 方法都可以修饰 禁止编译器的重排序，主要是对象
 * 创建过程中有可能改变顺序 比如还在创建过程中执行  但是已经将值赋给了变量  但其实是一个不能用的未经过初始化的对象变量，这个概念
 * 很重要
 */
public class SingleModel {

    //必须保证变量对象是私有的 防止别的类能够创建
    private volatile  SingleModel singleModel = null;
    public  SingleModel(){}
    public  SingleModel getSingleModel(){
        if(singleModel==null){
            synchronized (SingleModel.class){
                if(singleModel==null){
                    singleModel = new SingleModel();

                }
            }
        }
        return singleModel;
    }
}
