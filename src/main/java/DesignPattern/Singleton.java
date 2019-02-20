package DesignPattern;

public class Singleton {

    private Singleton() {}
    private  static volatile  Singleton instance;

    public static Singleton getInstance () {
        if(null == instance) {
            synchronized (Singleton.class) {
                if(null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //测试代码，验证100个线程去获取单例是不是一个实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton.getInstance().hashCode())).start();
        }

    }
}
