package com.xiaxin.reflection;

/**
 * ========================================================
 *
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test08
 * @Author : SiTi
 * @Time : 2025-02-14 14:24:02
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 分析 计算机性能
 */
public class Test08 {
    /* 十亿次 */
    public static int turn =  (int) 1E9;

    /* 1. 普通方式调用 */

    public static void test01() {
        CustomTest customTest = new CustomTest();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < turn; i++) {
            customTest.getMsg();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式执行十亿次: " + (int)(endTime - startTime) / 1000 + "s" + (endTime - startTime) % 1000 + "ms");
    }

    // 反射方式调用

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CustomTest customTest = new CustomTest();
        Class c1 = customTest.getClass();
        Method getMsg = c1.getDeclaredMethod("getMsg", null);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < turn; i++) {
            getMsg.invoke(customTest, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("反射方式执行十亿次: " + (int)(endTime - startTime) / 1000 + "s" + (endTime - startTime) % 1000 + "ms");
    }

    // 反射方式调用 关闭检测

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CustomTest customTest = new CustomTest();
        Class c1 = customTest.getClass();

        long startTime = System.currentTimeMillis();
        Method getMsg = c1.getDeclaredMethod("getMsg", null);

        getMsg.setAccessible(true);
        for (int i = 0; i < turn; i++) {
            getMsg.invoke(customTest, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("关闭检查后，反射方式执行十亿次: " + (int)(endTime - startTime) / 1000 + "s" + (endTime - startTime) % 1000 + "ms");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
}
