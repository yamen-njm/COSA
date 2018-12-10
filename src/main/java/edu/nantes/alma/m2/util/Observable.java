package edu.nantes.alma.m2.util;

import java.util.HashSet;
import java.util.Set;

public class Observable {

	private Set<Observer> observers = new HashSet<Observer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers(String message) {
		for (Observer observer : observers) {
			observer.update(this, message);
		}
	}
	
}
