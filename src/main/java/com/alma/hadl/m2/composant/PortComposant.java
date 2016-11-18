package com.alma.hadl.m2.composant;

import com.alma.hadl.m2.util.Service;

public abstract class PortComposant extends Service {
	
	private Composant composant;
	
	public void setComposant(Composant composant) {
		this.composant = composant;
	}
	
	
	public Composant getComposant() {
		return composant;
	}
	
}
