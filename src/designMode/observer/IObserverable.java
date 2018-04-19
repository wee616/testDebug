package designMode.observer;

/**
 * 被观察者修改时，主动通知观察者；同时提供了新增、删除观察者功能
 * 抽象被观察者接口
 * @author 11941
 *
 */
public interface IObserverable {
	
	public void addObserver(IObserver observer);
	
	public void removeObserver(IObserver observer);
	
	public void notifyObserver(String message);
}
