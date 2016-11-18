package com.alma.hadl.m2.composant;

import java.util.Map;
import java.util.HashMap;

public abstract class Composant {

	private Map<String, PortComposantFournis> portsFournis = new HashMap<String, PortComposantFournis>();
	private Map<String, PortComposantRequis> portsRequis = new HashMap<String, PortComposantRequis>();
	
	protected void ajouterPortFournis(String nom, PortComposantFournis portFournis) {
		portsFournis.put(nom, portFournis);
		portFournis.setComposant(this);
	}
	
	protected void ajouterPortRequis(String nom, PortComposantRequis portRequis) {
		portsRequis.put(nom, portRequis);
		portRequis.setComposant(this);
	}
	
	public PortComposantFournis getPortFournis(String nom) {
		return portsFournis.get(nom);
	}
	
	public PortComposantRequis getPortRequis(String nom) {
		return portsRequis.get(nom);
	}

}
