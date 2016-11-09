package com.alma.hadl.m2.configuration;

import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;

public class PortConfigurationRequis extends Observable implements Callable {
	
	@Override
	public void call(String message) {
		this.notifyObservers(message);
	}

}
