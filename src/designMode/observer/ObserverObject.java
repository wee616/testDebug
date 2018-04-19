package designMode.observer;

public class ObserverObject {

	public static void main(String[] args) {
		IObserverable iObserverable = new WechatServer();
		IObserver userOne = new User("userOne");
		IObserver userTwo = new User("userTwo");
		IObserver userThree = new User("userThree");
		iObserverable.addObserver(userOne);
		iObserverable.addObserver(userTwo);
		iObserverable.addObserver(userThree);
		iObserverable.notifyObserver(" we got it!");
		iObserverable.removeObserver(userThree);
		iObserverable.notifyObserver(" we got it again!");
	}

}
