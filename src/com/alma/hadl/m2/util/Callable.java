package com.alma.hadl.m2.util;

public abstract class Callable extends Observable {

	public void call(String message) {
		execute(message);
		this.notifyObservers(message);
	}
	
	protected void execute(String message) {
		
	}
	
}
