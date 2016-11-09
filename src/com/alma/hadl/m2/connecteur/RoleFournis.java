package com.alma.hadl.m2.connecteur;

import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;

public class RoleFournis extends Observable implements Callable {
	
	private Callable callable;
	
	public RoleFournis(Callable callable) {
		this.callable = callable;
	}

	@Override
	public void call(String message) {
		callable.call(message);
		this.notifyObservers(message);
	}
	
	public String getNom() {
		return getClass().getSimpleName();
	}

}
