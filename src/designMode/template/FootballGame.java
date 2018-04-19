package designMode.template;

public class FootballGame extends Game{

	@Override
	public void init() {
		System.out.println("football init");
	}

	@Override
	public void start() {
		System.out.println("football start");		
	}

	@Override
	public void end() {
		System.out.println("football end");		
	}

}
