package dta.chat.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ChatObservable<T> {
	private List<ChatObserver<T>> observers = new ArrayList<>();

	public void addObserver(ChatObserver<T> obs) {
		observers.add(obs);
	}

	public void removeObserver(ChatObserver<T> obs) {
		observers.remove(obs);
	}

	public void notifyObservers(T msg) {
		observers.forEach(obs -> obs.update(this, msg));
	}

}
