package org.un.hadl.m2.configuration;

import org.un.hadl.m2.composant.PortComposant;
import org.un.hadl.m2.composant.PortComposantFournis;
import org.un.hadl.m2.composant.PortComposantRequis;

public class Binding {
	
	private PortComposant portComposant;
	private PortConfiguration portConfiguration;

	public Binding(PortComposantRequis portComposant, PortConfigurationRequis portConfiguration) {
		this.portComposant = portComposant;
		this.portConfiguration = portConfiguration;
	}
	
	public Binding(PortComposantFournis portComposant, PortConfigurationFournis portConfiguration) {
		this.portComposant = portComposant;
		this.portConfiguration = portConfiguration;
	}
	
	public PortComposant getPortComposant() {
		return portComposant;
	}

	public PortConfiguration getPortConfiguration() {
		return portConfiguration;
	}
	
}
