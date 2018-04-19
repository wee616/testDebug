package designMode.observer;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements IObserverable {

	private List<IObserver> observers;

	public WechatServer() {
		observers = new ArrayList<IObserver>();
	}

	@Override
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		if (observers.size() != 0) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObserver(String message) {
		if (observers.size() <= 0) {
			return;
		}
		for (IObserver observer : observers) {
			observer.update(message);
		}
	}
}
