package com.xiaxin.reflection;

/**
 * ========================================================
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test06
 * @Author : SiTi
 * @Time : 2025-02-14 14:17:09
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获得类的信息

public class Test06 {
    public static void main(String[] args) {
        Class c1 = CustomTest.class;

        // 1. 获得类的名称
        System.out.println("====== 1. 获得类的名称 ======");
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        // 2. 获得类的属性
        System.out.println("======= 2. 获得类的属性 ======");
        // (1) 获得 本类及其父类所有 公有属性
        Field[] pFields = c1.getFields();
        for (Field pField : pFields) {
            System.out.println("getFields:" + pField + ": " + pField.getName());
        }
        // (2) 获得 本类所有属性
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("getDeclaredFields: " + field + ": " + field.getName());
        }
        // (3) 获得 指定属性(本类及其父类 所有 公有属性): 不存在或者权限不符合或参数不匹配  均会抛出异常
        try {
            Field pfield = c1.getField("D");
            System.out.println("getField: " + pfield + " -> " + pfield.getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // (4) 获得 指定属性(本类所有范围类的属性): 不存在或参数不匹配 会抛出异常
        try {
            Field field = c1.getDeclaredField("msg");
            System.out.println("getDeclaredField: " + field + " -> " + field.getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // 3. 获得类的方法
        System.out.println("===== 3. 获得类的方法 =====");
        // (1) 获得 本类及其父类所有的 public 方法
        Method[] pMethods = c1.getMethods();
        for (Method pMethod : pMethods) {
            System.out.println("getMethods: " + pMethod + ": " + pMethod.getName());
        }
        // (2) 获得 本类所有的方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods: " + method + ": " + method.getName());
        }

        // 注意重载，通过参数判断
        // (3) 获得指定方法 (本类及其父类 所有 公有方法): 不存在或者权限不符合 均会抛出异常
        try {
            Method pMethod = c1.getMethod("getMsg");
            System.out.println("getMethod: " + pMethod + " -> " + pMethod.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // (4) 获得指定方法 (本类所有方法): 不存在  会抛出异常
        try {
            Method method = c1.getDeclaredMethod("setMsg", String.class);
            System.out.println("getDeclaredMethod: " + method + " : " + method.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 4. 获得构造器
        // (1) 获得 本类所有 public 构造器
        System.out.println("===== 4. 获得构造器 =====");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor pConstructor : constructors) {
            System.out.println("getConstructors: " + pConstructor + ": " + pConstructor.getName());
        }

        // (2) 获得 本类所有 构造器
        Constructor[] pConstructors = c1.getDeclaredConstructors();
        for (Constructor pConstructor : pConstructors) {
            System.out.println("getDeclaredConstructors: " + pConstructor + ": " + pConstructor.getName());
        }

        // (3) 获得 指定的构造器 (公有类型)
        try {
            Constructor pConstructor = c1.getConstructor();
            System.out.println("getConstructor: " + pConstructor + " -> " + pConstructor.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // (4) 获得 指定构造器(所有类型)
        try {
            Constructor constructor = c1.getDeclaredConstructor(String.class, boolean.class);
            System.out.println("getDeclaredConstructor: " + constructor + " -> " + constructor.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomBasic {
    private String A;
    protected String B;
    static final String C = "TRUE";
    public String D;

    public CustomBasic() {}

    public String getA() {
        return A;
    }
    protected void setA(String A) {
        this.A = A;
    }
}

class CustomTest extends CustomBasic {
    private String msg = "UiQi";
    protected boolean state;
    static char VERSION = 'A';
    public int code;

    public CustomTest() {}
    public CustomTest(boolean state) {
        this.state = state;
    }
    private CustomTest(String msg, boolean state) {
        this.msg = msg;
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }
}