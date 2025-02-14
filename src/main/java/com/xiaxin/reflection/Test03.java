package com.xiaxin.reflection;

/**
 * ========================================================
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test03
 * @Author : SiTi
 * @Time : 2025-02-14 14:01:06
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

public class Test03 {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println("code = " + A.getCode() + ", " + "state = " + obj.getState());
    }
    /*
     * 1. A类 加载至内存, 会产生一个类对应的 Class 对象
     * 2. 链接，链接结束后 code = 0
     * 3. 初始化
     * <clint>() {
     *   System.out.println("A Class Static Block, code ?= " + "在定义之前不可读取值");
     *   code = 100;
     *   code = 10;
     * }
     * 4. 在运行其余
     * */
}

class A {
    static {
        System.out.println("A Class Static Block, code ?= " + "在定义之前不可读取值");
        code = 100;
    }
    private static int code = 10;
    private int state = -1;

    public A() {
        System.out.println("A Constructor Block, code = " + code);
        state = 0;
    }

    public static int getCode() {
        return code;
    }

    public int getState() {
        return state;
    }
}