package designMode.singleton;

public class SingleObject {
	
	public static void main(String[] args){
		SingleLazyUnsafe singleLazyUnsafe = SingleLazyUnsafe.getInstance();
		singleLazyUnsafe.print();
		
		SingleLazySafeOne singleLazySafeOne = SingleLazySafeOne.getInstance();
		singleLazySafeOne.print();
		
		SingleLazySafeTwo singleLazySafeTwo = SingleLazySafeTwo.getInstance();
		singleLazySafeTwo.print();
		
		SingleHungry singleHungry = SingleHungry.getInstance();
		singleHungry.print();
		
		SingleFinal singleFinal = SingleFinal.getInstance();
		singleFinal.print();
		
		SingleEnum singleEnum = SingleEnum.INSTANCE;
		singleEnum.print();
	}
}
