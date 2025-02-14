package com.xiaxin.annotation;

import java.lang.annotation.*;

@HPAnnotation
public class CHavaParameter {
    @HPAnnotation("Information")
    private String msg;
    @HPAnnotation()
    public String getMsg(){
        return msg;
    }
}

/**
 * @author UiQi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@interface HPAnnotation {
    String value() default "";
}

