package com.alma.hadl.m2.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Callable extends Observable {
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	public void call(String message) {
		logger.trace(message);
		execute(message);
		this.notifyObservers(message);
	}
	
	protected void execute(String message) {
		
	}
	
}
