package practice_6.Prototype;

public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	void draw() {
		System.out.println("Draw Rectangle");
	}
}
