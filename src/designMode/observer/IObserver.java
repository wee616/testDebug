package designMode.observer;

/**
 * 抽象观察者，提供了update方法，供观察者调用
 * @author 11941
 *
 */
public interface IObserver {
	
	public void update(String message);
}
