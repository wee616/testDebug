package designMode.singleton;

public class SingleFinal {
	
	public void print(){
		System.out.println(SingleFinal.class.getName());
	}
	
	private SingleFinal(){}

	// 静态内部类只有在被调用时才初始化，且只会被初始化一次
	private static class InstanceHolder{
		
		private static final SingleFinal instance = new SingleFinal();
	}
	
	public static SingleFinal getInstance(){	
		return InstanceHolder.instance;
	}

}
