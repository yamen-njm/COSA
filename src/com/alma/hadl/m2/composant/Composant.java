package com.alma.hadl.m2.composant;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Composant {

	private Map<String, PortComposantFournis> portsFournis = new HashMap<String, PortComposantFournis>();
	private Map<String, PortComposantRequis> portsRequis = new HashMap<String, PortComposantRequis>();
	private List<Service> services = new ArrayList<Service>();
	
	protected void ajouterPortFournis(PortComposantFournis portFournis) {
		portsFournis.put(portFournis.getNom(), portFournis);
		portFournis.setComposant(this);
	}
	
	protected void ajouterPortRequis(PortComposantRequis portRequis) {
		portsRequis.put(portRequis.getNom(), portRequis);
		portRequis.setComposant(this);
	}
	
	protected void ajouterService(Service service) {
		services.add(service);
	}
	
	public PortComposantFournis getPortFournis(String nom) {
		return portsFournis.get(nom);
	}
	
	public PortComposantRequis getPortRequis(String nom) {
		return portsRequis.get(nom);
	}

}
