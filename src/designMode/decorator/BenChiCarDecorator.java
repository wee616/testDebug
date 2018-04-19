package designMode.decorator;

/**
 * 
 * 继承，用于实现功能；聚合，用于调用基本功能。 动态的给对象增加功能
 * 装饰模式和代理模式的相同点：
 * 都实现了同一个接口
 * 装饰器模式和代理模式的不同点：
 * 装饰器模式通常是将原始对象作为参数传进装饰器的构造方法中；
 * 代理模式通常是在代理类中创建对象的实例
 *
 */
public class BenChiCarDecorator implements ICar {

	private ICar car;

	public BenChiCarDecorator(ICar car) {
		this.car = car;
	}

	@Override
	public void run() {
		this.showLogo();
		this.car.run();
	}

	private void showLogo() {
		System.out.println("benchi");
	}

}
