package practice_6.AbstractFactory;

public class Client {
    public Chair chair;

    public void sit() {
        System.out.println("Sit...");
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
