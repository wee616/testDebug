package beautifulOfCode.divList;

public class Test {

	public static void main(String[] args) {
		DivList divList = new DivList();
		//test
		Double[] request = {11.22,22.33,33.8967,0.00};
		Double[] responce = divList.test1(request);
		divList.showResponce(responce);
		System.out.println("--------------");
		responce = divList.test2(request);
		divList.showResponce(responce);
		//test
		request = null;
		responce = divList.test1(request);
		divList.showResponce(responce);
		System.out.println("--------------");
		responce = divList.test2(request);
		divList.showResponce(responce);
	}

}
