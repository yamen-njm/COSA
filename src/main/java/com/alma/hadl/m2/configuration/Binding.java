package com.alma.hadl.m2.configuration;

import com.alma.hadl.m2.composant.Port;

public class Binding {
	
	private Port from;
	private Port to;

	public Binding(Port portFrom, Port portTo) {
		from = portFrom;
		to = portTo;
	}
	
	public Port getFrom() {
		return from;
	}

	public Port getTo() {
		return to;
	}
	
}
