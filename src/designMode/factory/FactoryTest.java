package designMode.factory;

public class FactoryTest {

	public static void main(String[] args) {
		ColorFactory factory = new ColorFactory();
		Color color = factory.createColor("RED");
		color.drow();
	}

}
