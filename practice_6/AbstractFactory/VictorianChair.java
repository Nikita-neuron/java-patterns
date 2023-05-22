package practice_6.AbstractFactory;

public class VictorianChair implements Chair {
    private int age;

    public int getAge(){
        return age;
    }

    public VictorianChair(int age) {
        this.age = age;
    }
}
