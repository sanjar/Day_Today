package com.sanjar.hacker.earth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Person { public int number; }

class MyThread extends Thread{
public String text;
public void run(){
//System.out.print(text);
}
}

public class Test{
public static void main(String args[]){
MyThread t1 = new MyThread();
MyThread t2 = new MyThread();
t1.start();
t2.start();
//System.out.print("three ");


final int i = 22;
byte b = i;
//System.out.println(i + ", " + b);

Set h = new HashSet();
h.add("One");
h.add("Two");
h.add("Three");
h.add("Four");
h.add("One");
h.add("Four");
List l = new ArrayList();
l.add("One");
l.add("Two");
l.add("Three");
h.retainAll(l);
System.out.println("Size:" + l.size()+ h.size());
}

}
