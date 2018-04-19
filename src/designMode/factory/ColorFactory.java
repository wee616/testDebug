package designMode.factory;

public class ColorFactory {
	
	public Color createColor(String color){
		if("YELLOW".equals(color)){
			return new Yellow();
		}else{
			return new Red();
		}
	}
}
