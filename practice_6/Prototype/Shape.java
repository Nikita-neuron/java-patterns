package practice_6.Prototype;

public abstract class Shape implements Cloneable {

	protected String type;

	abstract void draw();

	@Override
	public Shape clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Shape) clone;
	}
}
