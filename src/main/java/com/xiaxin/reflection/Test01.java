package com.xiaxin.reflection;

public class Test01 {
    // 通过反射获取类的Class对象

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 通过类名
        // 已知一个类的全类名，且该类在类的路径下，可以通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException
        Class c1 = Class.forName("com.xiaxin.reflection.example01.Animal");
        Class c2 = Class.forName("com.xiaxin.reflection.example01.Animal");
        Class c3 = Class.forName("com.xiaxin.reflection.example01.Animal");
        Class s1 = Class.forName("java.lang.String");
        System.out.println(c1 + "   " + s1);

        // 一个类在内存中只有一个Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println("hashCode: c1:"+ c1.hashCode() + "\n"
                + "hashCode: c2:"+ c2.hashCode() + "\n"
                + "hashCode: c3:"+ c3.hashCode() + "\n"
                + "hashCode: s1:"+ s1.hashCode());

        // 2. 通过实例
        // 已知某个类的实例，调用该实例的getClass()方法获取Class对象
        // 注意: Class类的一个实例，与Animal类的实例
        Class cc1 = c1.getClass();
        Class e2 = new Animal().getClass();
        Class s2 = "UiQi".getClass();
        System.out.println(cc1 + "   " + s2);
        System.out.println("hashCode: cc1:"+ c1.hashCode() + "\n"
                + "hashCode: e2:"+ e2.hashCode() + "\n"
                + "hashCode: s1:"+ s2.hashCode());

        // 3. 类字面量
        // 若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最佳
        Class w1 = Animal.class;
        Class w2 = Animal.class;
        Class s3 = String.class;
        System.out.println(w1 + "   " + s3);
        System.out.println("hashCode: w1:"+ w1.hashCode() + "\n"
                + "hashCode: w2:"+ w2.hashCode() + "\n"
                + "hashCode: s3:"+ s3.hashCode());

        // 4. 内置的基本类型中的包装类有Type属性
        // Boolean、Byte、Character、Short、Integer、Long、Float、Double、Void
        Class i1 = Integer.TYPE;
        Class i2 = Integer.TYPE;
        Class x1 = Void.TYPE;
        System.out.println(i1 + "   " + i2 + "       " + x1);
        System.out.println("hashCode: i1:"+ i1.hashCode() + "\n"
                + "hashCode: i2:"+ i2.hashCode() + "\n"
                + "hashCode: x1:"+ x1.hashCode() + "\n");

        // 5. 获取父类的Class类型
        Class t1 = Tom.class;
        Class f1 = t1.getSuperclass();
        System.out.println(t1 + "   " + f1);
    }
}

// 实体类 pojo，entity，bean，dto

class Animal {
    private String name;
    private int age;

    public Animal() {
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Tom extends Animal {}