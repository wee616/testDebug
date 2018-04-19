package designMode.decorator;

public class DecoratorProject {

	public static void main(String[] args) {
		BenChiCarDecorator benChiCarDecorator = new BenChiCarDecorator(new Car());
		benChiCarDecorator.run();
	}

}
