package designMode.singleton;

public class SingleLazySafeOne {

	public void print(){
		System.out.println(SingleLazySafeOne.class.getName());
	}
	
	//构造函数定义为私有的，防止被调用
	private SingleLazySafeOne(){};
	
	private static SingleLazySafeOne instance;
	
	//若instance为空，进行初始化，运行时初始化，线程安全，但并发效率低
	public static synchronized SingleLazySafeOne getInstance(){
		if(instance == null){
			instance = new SingleLazySafeOne();
		}
		return instance;
	}
}
