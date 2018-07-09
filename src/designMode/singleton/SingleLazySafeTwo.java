package designMode.singleton;

public class SingleLazySafeTwo {

	public void print(){
		System.out.println(SingleLazySafeTwo.class.getName());
	}
	
	//构造函数定义为私有的，防止被调用
	private SingleLazySafeTwo(){};
	
	private static volatile SingleLazySafeTwo instance;
	
	//若instance为空，进行初始化，运行时初始化，代码块加synchronized线程安全，效率高
	public static SingleLazySafeTwo getInstance(){
		if(instance == null){
			synchronized(SingleLazySafeTwo.class){
				if(instance == null){
					//此处由于new 不是原子性动作，因此instance需要用volatile进行修饰
					instance = new SingleLazySafeTwo();
				}
			}
		}
		return instance;
	}
}
