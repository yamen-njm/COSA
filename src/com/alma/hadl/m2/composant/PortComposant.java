package com.alma.hadl.m2.composant;

public abstract class PortComposant extends Port {
	
	private Composant composant;
	
	public void setComposant(Composant composant) {
		this.composant = composant;
	}
	
	
	public Composant getComposant() {
		return composant;
	}
	
}
