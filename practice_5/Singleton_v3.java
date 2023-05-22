package practice_5;

public class Singleton_v3 {
    private static Singleton_v3 instance = new Singleton_v3();

    private Singleton_v3() {}

    public static Singleton_v3 getInstance() {
        return instance;
    }
}
