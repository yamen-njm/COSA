package com.alma.hadl.m2.connecteur;

import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;

public class RoleRequis extends Observable implements Callable {

	@Override
	public void call(String message) {
		this.notifyObservers(message);
	}
	
	public String getNom() {
		return getClass().getSimpleName();
	}

}
