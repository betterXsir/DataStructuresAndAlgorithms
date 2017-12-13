package com.hzh;

/**
 * Created by huzhenhua on 2017/11/8.
 */
public class Dog extends Object {
    public Dog(int i){
        System.out.println("Dog " + i + " ");
    }

    public void bark(int a, String b){
        System.out.println("barking");
    }

    public void bark(String a, int b){
        System.out.println("howling");
    }

    public static void main(String[] args) {
        Dog dog = new Dog(1);
        dog.bark(2, "haha");
        dog.bark("hehe", 3);
        System.out.println(Spiciness.valueOf("HOT"));
    }
}
