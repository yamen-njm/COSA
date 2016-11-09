package com.alma.hadl.m2.composant;

import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;

public class PortComposantFournis extends Observable implements Callable {
		
	private Callable callable;
	
	public PortComposantFournis(Callable callable) {
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
