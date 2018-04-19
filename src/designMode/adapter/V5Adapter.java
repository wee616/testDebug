package designMode.adapter;

/**
 * 有多种实现方式，继承+实现  聚合+实现，这里采用聚合+实现
 * @author 11941
 *
 */
public class V5Adapter implements IV5 {
	
	private V200 v200;
	
	public V5Adapter(V200 v200){
		this.v200 = v200;
	}
	
	@Override
	public void out() {
		if(v200 != null){
			System.out.println("change to v5");
		}
	}

}
