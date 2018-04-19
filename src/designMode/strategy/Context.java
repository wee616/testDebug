package designMode.strategy;

/**
 * 三个角色：抽象策略角色、具体策略角色、环境角色
 * 
 * @author 11941
 *
 */
public class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	public Integer doActions(Integer num1, Integer num2) {
		return strategy.doOperation(num1, num2);
	}
}
