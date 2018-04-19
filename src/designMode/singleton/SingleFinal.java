package designMode.singleton;

public class SingleFinal {
	
	public void print(){
		System.out.println(SingleFinal.class.getName());
	}
	
	private SingleFinal(){}
	
	
	
	private static class InstanceHolder{
		
		private static final SingleFinal instance = new SingleFinal();
	}
	
	public static SingleFinal getInstance(){	
		return InstanceHolder.instance;
	}

}
