package test;

public class Singleton {
    public Singleton() {
    }

    private volatile static Singleton instance;

    public static Singleton getSingleton() {
        if(instance == null ) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
