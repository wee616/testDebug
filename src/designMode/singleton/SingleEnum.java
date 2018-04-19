package designMode.singleton;

public enum SingleEnum {
	
	INSTANCE;
	
	public void print(){
		System.out.println(SingleEnum.class.getName());
	}
	
}
