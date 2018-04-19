package designMode.template;

public class BasketballGame extends Game{

	@Override
	public void init() {
		System.out.println("basketball init");
	}

	@Override
	public void start() {
		System.out.println("basketball start");		
	}

	@Override
	public void end() {
		System.out.println("basketball end");		
	}

}
