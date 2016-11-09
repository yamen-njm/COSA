package com.alma.hadl.m2.composant;

import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;

public class PortComposantRequis extends Observable implements Callable {

	@Override
	public void call(String message) {
		this.notifyObservers(message);
	}
	
	public String getNom() {
		return getClass().getSimpleName();
	}

}
