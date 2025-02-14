package com.xiaxin.reflection;

/**
 * ========================================================
 *
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test07
 * @Author : SiTi
 * @Time : 2025-02-14 14:20:16
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通过反射动态创建对象
public class Test07 {
    public static void main(String[] args) throws NoSuchMethodException {
        // 1. 获得 Class 对象
        Class c = null;
        try {
            c = Class.forName("com.xiaxin.reflection.example01.CustomTest");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
            // 会中断 Java 代码的运行
        }

        // 2. 构造一个对象
        CustomTest obj;
        try {
            // (1) 调用了类的无参构造器
            obj = (CustomTest) c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 扩展 权限修饰 访问范围
        // 同一个 包目录下(同一个目录中) 可以直接访问 所有 的类 (public、package权限)
        // protected 修饰的元素: 子类也可以访问
        System.out.println("父类 package static C: " + CustomTest.C);
        System.out.println("父类 protected B: " + obj.B);

        // (2) 通过构造器创建对象

        Constructor constructor = null;
        try {
            constructor = c.getDeclaredConstructor(boolean.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        CustomTest obj2 = null;

        try {
            obj2 = (CustomTest) constructor.newInstance(true);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.println(obj2.state);

        // 3. 通过反射调用普通方法

        // (1) 创建一个对象
        CustomTest obj3 = null;
        try {
            obj3 = (CustomTest) c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // (2) 通过反射获取一个 方法

        // a. private 方法 无法 激活
        // 通过 关闭安全检查机制即可
        Method setMsg = c.getDeclaredMethod("setMsg", String.class);

        try {
            // 激活执行方法
            setMsg.setAccessible(true);
            setMsg.invoke(obj3, "滴答");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // b. public 方法
        Method getMsg = c.getDeclaredMethod("getMsg");
        try {
            // 激活执行方法
            Object o = getMsg.invoke(obj3);
            System.out.println(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        // 4. 通过反射操作属性
        // (1) 生成一个对象
        CustomTest obj4 = null;
        try {
            obj4 = (CustomTest) c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // (2) 获取属性
        Field state = null;
        Field msg = null;
        try {
            state = c.getDeclaredField("state");
            msg = c.getDeclaredField("msg");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        // (3) 设置属性的值
        try {
            state.set(obj4, true);
            // 不能直接操作私有属性，无法设置 private 限定的属性 ?? 可以
            // 设置为 true， 关闭安全检查， 就可以设置 私有属性的值了
            msg.setAccessible(true);
            msg.set(obj4, "AiMi");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(obj4.state);
        System.out.println(obj4.getMsg());
    }
}
