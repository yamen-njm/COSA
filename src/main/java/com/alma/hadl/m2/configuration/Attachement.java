package com.alma.hadl.m2.configuration;

import com.alma.hadl.m2.util.Callable;

public class Attachement {

	private Callable from;
	private Callable to;
	
	public Attachement(Callable from, Callable to) {
		this.from = from;
		this.to = to;
	}
	
	public Callable getFrom() {
		return from;
	}

	public Callable getTo() {
		return to;
	}

}
