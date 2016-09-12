package com.abc.amazon.automation.test;

/**
 * Created by Sumedha on 7/22/2016.
 */
public  class A {

    A(){
        System.out.println("First A");
    }
    A(int x) {
        System.out.println(x);
    }
    A(int x, int y){
        System.out.println(x +" "+ y);
    }
    public  String getString(){
        return "ClassA";
    }


    public static void main(String[] args) {

        B a = new B();
        System.out.println(a.getString());
        System.out.println(a.getSupperString());


    }
    public static boolean classCheck(A a){
        if(a.getString().contains("B")){
            return true;
        } else return false;
    }

}

class B extends A{
    B(){

    }

    B(int x , int y){
        super(x,y);
    }
    @Override
    public String getString(){
        return "calssB";
    }

    public String getSupperString(){
        return super.getString();
    }

}