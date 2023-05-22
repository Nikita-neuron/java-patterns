package practice_5;

public enum Singleton_v2 {
    INSTANCE;

    private Singleton_v2() {}

    public static Singleton_v2 getInstance() {
        return INSTANCE;
    }
}
