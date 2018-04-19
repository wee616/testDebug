package designMode.observer;

public class User implements IObserver {

	private String name;
	
	public User(String name){
		this.name = name;
	}
	
	@Override
	public void update(String message) {
		System.out.println(name + message);
	}

}
