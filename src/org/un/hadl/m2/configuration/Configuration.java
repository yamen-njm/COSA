package org.un.hadl.m2.configuration;

import java.util.ArrayList;
import java.util.List;

import org.un.hadl.m2.composant.Composant;
import org.un.hadl.m2.connecteur.Connecteur;

public class Configuration {

	private List<Composant> composants = new ArrayList<Composant>();
	private List<Configuration> configurations = new ArrayList<Configuration>();
	private List<Connecteur> connecteurs = new ArrayList<Connecteur>();
	
	private List<Attachement> attachements = new ArrayList<Attachement>();
	private List<Binding> bindings = new ArrayList<Binding>();
	
	private List<PortConfiguration> ports = new ArrayList<PortConfiguration>();
	
}
