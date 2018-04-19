package designMode.adapter;

public class AdapterObject {

	public static void main(String[] args) {
		V200 v200 = new V200();
		v200.out();
		V5Adapter v5Adapter = new V5Adapter(v200);
		v5Adapter.out();
	}

}
