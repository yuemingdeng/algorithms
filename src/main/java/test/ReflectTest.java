package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {

        Class clazz = null;
        Method method = null;

        clazz = Class.forName("test.Fruit");
        Constructor<Fruit> fruitConstructor = clazz.getConstructor(String.class);
        Fruit fruit = fruitConstructor.newInstance("Apple");    //创建有参对象实例

        method = clazz.getMethod("show",null);  //获取空参数 show 方法
        method.invoke(fruit,null);  //执行无参方法

        method = clazz.getDeclaredMethod("show",int.class); //获取有参 show 方法
        method.setAccessible(true);
        method.invoke(fruit,20);  //执行有参方法


    }
}

class Fruit {
    private String type;

    public Fruit() {
    }

    public Fruit(String type) {
        this.type = type;
    }

    public void show() {
        System.out.println("Fruit type = " + type);
    }

    private void show(int num) {
        System.out.println("Fruit type = " + type + ".....Fruit num = " + num);
    }

}
