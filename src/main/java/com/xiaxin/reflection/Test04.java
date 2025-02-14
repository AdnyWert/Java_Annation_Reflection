package com.xiaxin.reflection;

/**
 * ========================================================
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test04
 * @Author : SiTi
 * @Time : 2025-02-14 14:06:34
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

public class Test04 {
    static {
        System.out.println("Test04 static block");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 类初始化(加载)的方式

        // 1. 主动引用
        // Son son = new Son();

        // 2. 反射产生主动引用
        // Class.forName("com.xiaxin.reflection.example01.Son");

        // 不会产生类的引用(加载)的方式
        // 1. 调用父类的静态属性或方法
        // System.out.println(Son.fa);

        // 2. 创建一个类型的数组
        // Son[] sons = new Son[10];

        // 3. 调用常量
        System.out.println(Son.CODE);
    }
}

class Father {
    static int fa = -1;
    static {
        System.out.println("Father static block");
    }
}

class Son extends Father {
    static {
        System.out.println("Son static block");
        code = 100;
    }
    static int code = 10;
    static final int CODE = 1;
}
