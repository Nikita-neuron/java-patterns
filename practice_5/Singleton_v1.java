package practice_5;

public class Singleton_v1 {
    private static Singleton_v1 instance;

    private Singleton_v1() {}

    public static synchronized Singleton_v1 getInstance() {
        if(instance == null) {
            instance = new Singleton_v1();
            return instance;
        }
        return instance;
    }
}
