package designMode.strategy;

public class StrategyAdd implements IStrategy {

	@Override
	public Integer doOperation(Integer num1, Integer num2) {
		return num1 + num2;
	}

}
