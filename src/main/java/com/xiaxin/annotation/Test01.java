package com.xiaxin.annotation;

import java.lang.annotation.*;

/**
 * ========================================================
 *
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.annotation.Test01
 * @Author : SiTi
 * @Time : 2025-02-14 12:19:59
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

@TargetRetentionAnnotation
public class Test01 {
    @TargetRetentionAnnotation02
    public static void hi(){
        System.out.println("Hello XiaXin");
    }

    public static void main(String[] args) {
        hi();
    }
}

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
@SuppressWarnings("all")
@interface TargetRetentionAnnotation {
    String value() default "None";
}

/**
 * @author UiQi
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD})
@interface TargetRetentionAnnotation02 {
    String description() default "None";
}