package practice_3;

public class Practice_3_Main {
    public static void main(String[] args) throws InterruptedException {
//        checkList();
        checkSet();
    }

    public static void checkList() throws InterruptedException {
        ListImpl<Integer> list = new ListImpl<>();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) list.add(i);
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 1000; i++) list.add(i);
        });

        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(list.size());
    }

    public static void checkSet() throws InterruptedException {
        SetImpl set = new SetImpl();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) set.add(i);
        });

        Thread two = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) set.add(i);
        });

        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(set.size());
    }
}
