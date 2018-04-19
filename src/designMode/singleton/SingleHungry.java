package designMode.singleton;

public class SingleHungry {
	
	public void print(){
		System.out.println(SingleHungry.class.getName());
	}
	
	private SingleHungry(){};
	
	private static SingleHungry instance = new SingleHungry();
	
	public static SingleHungry getInstance(){
		return instance;
	}
}
