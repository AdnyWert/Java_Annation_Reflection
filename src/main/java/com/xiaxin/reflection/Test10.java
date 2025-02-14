package com.xiaxin.reflection;

/**
 * ========================================================
 *
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test10
 * @Author : SiTi
 * @Time : 2025-02-14 14:30:02
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */


import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * ORM : 练习反射和注解
 */
public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class c = Class.forName("com.xiaxin.reflection.example01.Person");

        // 通过反射获得注解信息 仅用于运行时保留

        // 获取类上的注解信息
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation + " : " + annotation.annotationType());
        }

        // 获得注解的 value 的值
        TableName tName = (TableName) c.getAnnotation(TableName.class);
        System.out.println(tName.value());

        // 获得类指定元素的注解
        Field name = c.getDeclaredField("id");
        FieldName annotation = name.getAnnotation(FieldName.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@SuppressWarnings("all")
@TableName("tb_person")
class Person {
    @FieldName(columnName = "pid", type = "int", length = 9)
    private int id;
    @FieldName(columnName = "name", type = "varchar", length = 20)
    private String name;
    @FieldName(columnName = "gender", type = "char", length = 1)
    private char gender;

    public Person() {}

    public Person(int id, String name, int age, char gender) {
        this.name = name;
    }
}

/**
 * 类名的注解
 * @author Lenovo
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableName {
    String value();
}

/**
 * 属性的注解
 * @author AiMi, UiQi, SiTi
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldName {
    String columnName();
    String type();
    int length();
}