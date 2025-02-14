package com.xiaxin.reflection;

/**
 * ========================================================
 *
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test09
 * @Author : SiTi
 * @Time : 2025-02-14 14:27:35
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型信息
 */
public class Test09<M> {
    public<T> void test01(Map<String, CustomTest> map, List<T> list) {
        System.out.println("method test01");
    }

    public<E extends M> Map<E, CustomTest> test02() {
        System.out.println("method test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test09.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("getGenericParameterTypes(): " + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("getActualTypeArguments(): " + actualTypeArgument);
                }
            }
        }

        method = Test09.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("getActualTypeArguments(): " + actualTypeArgument);
            }
        }

    }
}