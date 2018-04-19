package designMode.strategy;

public class StrategyObject {

	public static void main(String[] args) {
		Context contextAdd = new Context(new StrategyAdd());
		Integer result = contextAdd.doActions(1, 2);
		System.out.println(result);
		Context contextSub = new Context(new StrategySub());
		result = contextSub.doActions(1, 2);
		System.out.println(result);
	}

}
