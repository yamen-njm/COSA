package com.alma.hadl.m2.configuration;

import java.util.ArrayList;
import java.util.List;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.connecteur.Connecteur;

public class Configuration {

	private List<Composant> composants = new ArrayList<Composant>();
	private List<Connecteur> connecteurs = new ArrayList<Connecteur>();
		
	private List<PortConfigurationFournis> portsFournis = new ArrayList<PortConfigurationFournis>();
	private List<PortConfigurationRequis> portsRequis = new ArrayList<PortConfigurationRequis>();
	
	protected Configuration() {
	}
	
	protected void ajouterComposant(Composant composant) {
		composants.add(composant);
	}
	
	protected void ajouterConnecteur(Connecteur connecteur) {
		connecteurs.add(connecteur);
	}
	
	protected void ajouterPortFournis(PortConfigurationFournis portFournis) {
		portsFournis.add(portFournis);
	}
	
	protected void ajouterPortRequis(PortConfigurationRequis portRequis) {
		portsRequis.add(portRequis);
	}
	
}
