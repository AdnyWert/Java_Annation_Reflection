package com.xiaxin.annotation;

import java.lang.reflect.Method;


public class Test02 {
    public static void main(String[] args) throws Exception {
        // 创建自定义类的实例
        MyClass myObject = new MyClass("UiQi");

        // 使用Object类的方法
        System.out.println(myObject.toString()); // 输出对象的字符串表示
        System.out.println(myObject.equals(new MyClass("UiQi"))); // 比较两个对象是否相等

        // 获取Class对象
        Class<?> clazz = myObject.getClass();
        System.out.println(clazz.getName()); // 输出类的全限定名

        // 使用Class对象创建实例
        MyClass anotherObject = (MyClass) clazz.getDeclaredConstructor(String.class).newInstance("Alice");
        System.out.println(anotherObject.toString()); // 输出新创建对象的字符串表示

        // 使用Class对象调用方法
        Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
        setNameMethod.invoke(anotherObject, "Bob");
        System.out.println(anotherObject.toString()); // 输出修改后的对象字符串表示
    }
}

class MyClass {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{name='" + name + "'}";
    }
}