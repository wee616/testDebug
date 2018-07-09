package designMode.singleton;
//枚举方式实现单例模式
public enum SingleEnum {
	
	INSTANCE;
	
	public void print(){
		System.out.println(SingleEnum.class.getName());
	}
	
}
