package com.alma.hadl.m2.configuration;

import com.alma.hadl.m2.util.Service;

public class Binding {
	
	private Service from;
	private Service to;

	public Binding(Service portFrom, Service portTo) {
		from = portFrom;
		to = portTo;
	}
	
	public Service getFrom() {
		return from;
	}

	public Service getTo() {
		return to;
	}
	
}
