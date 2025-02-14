package com.xiaxin.reflection;

/**
 * ========================================================
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test05
 * @Author : SiTi
 * @Time : 2025-02-14 14:11:57
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载的父类加载器 --> 扩展加载器
        ClassLoader parentClassLoader = systemClassLoader.getParent();
        System.out.println(parentClassLoader);

        // 获取扩展加载器的父类加载器 --> 根加载器(C/C++)
        ClassLoader classLoader = parentClassLoader.getParent();
        System.out.println(classLoader);

        // 测试当前类是那个加载器加载的
        ClassLoader classLoader1 = Class.forName("com.xiaxin.reflection.example01.Test05").getClassLoader();
        System.out.println(classLoader1);

        // 测试 JDK 内置的类(核心类库)是谁加载的
        ClassLoader classLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader2);

        // 如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        // 双亲委派机制规定，当一个类加载器加载某个类时，它会先将请求委派给父类加载器，只有当父类加载器无法加载该类时，才会尝试自己加载。
    }
}
