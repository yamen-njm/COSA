package edu.nantes.alma.m2.configuration;

import edu.nantes.alma.m2.util.Service;

public class Attachement {

	private Service from;
	private Service to;
	
	public Attachement(Service from, Service to) {
		this.from = from;
		this.to = to;
	}
	
	public Service getFrom() {
		return from;
	}

	public Service getTo() {
		return to;
	}

}
