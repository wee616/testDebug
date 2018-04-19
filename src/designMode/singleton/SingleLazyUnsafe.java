package designMode.singleton;

public class SingleLazyUnsafe {

	public void print(){
		System.out.println(SingleLazyUnsafe.class.getName());
	}
	
	//构造函数定义为私有的，防止被调用
	private SingleLazyUnsafe(){};
	
	private static SingleLazyUnsafe instance;
	
	//若instance为空，进行初始化，运行时初始化，if判断没有加synchronized，线程不安全
	public static SingleLazyUnsafe getInstance(){
		if(instance == null){
			instance = new SingleLazyUnsafe();
		}
		return instance;
	}
}
