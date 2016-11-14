package com.alma.hadl.m2.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;
import com.alma.hadl.m2.util.Observable;
import com.alma.hadl.m2.util.Observer;

public abstract class Configuration implements Observer {

	private List<Attachement> attachements = new ArrayList<Attachement>();
	private List<Binding> bindings = new ArrayList<Binding>();
		
	private Map<String, PortConfigurationFournis> portsFournis = new HashMap<String, PortConfigurationFournis>();
	private Map<String, PortConfigurationRequis> portsRequis = new HashMap<String, PortConfigurationRequis>();
	
	protected void ajouterPortFournis(PortConfigurationFournis portFournis) {
		portsFournis.put(portFournis.getNom(), portFournis);
	}
	
	protected void ajouterPortRequis(PortConfigurationRequis portRequis) {
		portsRequis.put(portRequis.getNom(), portRequis);
	}
	
	public PortConfigurationFournis getPortFournis(String nom) {
		return portsFournis.get(nom);
	}
	
	public PortConfigurationRequis getPortRequis(String nom) {
		return portsRequis.get(nom);
	}
	
	@Override
	public void update(Observable observable, String message) {
		System.out.println("[" + this.getClass().getName() + "] : " + observable.getClass().getName());

		for (Attachement attachement : attachements) {
			if (attachement.getFrom() == observable) {
				attachement.getTo().call(message);
			}
		}
		
		for (Binding binding : bindings) {
			if (binding.getFrom() == observable) {
				binding.getTo().call(message);
			}
		}
	}
	
	/**
	 * port requis <-> role fournis
	 * 
	 * @param portRequis
	 * @param roleFournis
	 */
	protected void attacher(PortComposantRequis portRequis, RoleFournis roleFournis) {
		attachements.add(new Attachement(portRequis, roleFournis));
		portRequis.addObserver(this);
	}
	
	/**
	 * port fournis <-> role requis
	 * 
	 * @param portFournis
	 * @param roleRequis
	 */
	protected void attacher(PortComposantFournis portFournis, RoleRequis roleRequis) {
		attachements.add(new Attachement(roleRequis, portFournis));
		roleRequis.addObserver(this);
	}
	
	/**
	 * port requis <-/-> role fournis
	 * 
	 * @param portRequis
	 * @param roleFournis
	 */
	protected void detacher(PortComposantRequis portRequis, RoleFournis roleFournis) {
		portRequis.removeObserver(this);
		attachements.removeIf(attachement -> attachement.getFrom() == portRequis && attachement.getTo() == roleFournis);
	}
	
	/**
	 * port fournis <-/-> role requis
	 * 
	 * @param portFournis
	 * @param roleRequis
	 */
	protected void detacher(PortComposantFournis portFournis, RoleRequis roleRequis) {
		roleRequis.removeObserver(this);
		attachements.removeIf(attachement -> attachement.getTo() == portFournis && attachement.getFrom() == roleRequis);
	}
	
	/// Composant -> Configuration
	protected void bind(PortComposantRequis portComposant, PortConfigurationRequis portConfiguration) {
		bindings.add(new Binding(portComposant, portConfiguration));
		portComposant.addObserver(this);
	}
	
	protected void bind(PortComposantFournis portComposant, PortConfigurationFournis portConfiguration) {
		bindings.add(new Binding(portComposant, portConfiguration));
		portComposant.addObserver(this);
	}
	
	/// Configuration -> Composant
	protected void bind(PortConfigurationRequis portConfiguration, PortComposantRequis portComposant) {
		bindings.add(new Binding(portConfiguration, portComposant));
		portConfiguration.addObserver(this);
	}
	
	protected void bind(PortConfigurationFournis portConfiguration, PortComposantFournis portComposant) {
		bindings.add(new Binding(portConfiguration, portComposant));
		portConfiguration.addObserver(this);
	}
	
	/// Composant -/-> Configuration
	/**
	 * requis -> requis
	 */
	protected void unbind(PortComposantRequis portComposant, PortConfigurationRequis portConfiguration) {
		portComposant.removeObserver(this);
		bindings.removeIf(binding -> binding.getFrom() == portComposant && binding.getTo() == portConfiguration);
	}
	
	/**
	 * fournis -> fournis
	 */
	protected void unbind(PortComposantFournis portComposant, PortConfigurationFournis portConfiguration) {
		portComposant.removeObserver(this);
		bindings.removeIf(binding -> binding.getFrom() == portComposant && binding.getTo() == portConfiguration);
	}
	
	/// Configuration -/-> Composant
	/**
	 * requis -> requis
	 */
	protected void unbind(PortConfigurationRequis portConfiguration, PortComposantRequis portComposant) {
		portConfiguration.removeObserver(this);
		bindings.removeIf(binding -> binding.getFrom() == portConfiguration && binding.getTo() == portComposant);
	}
	
	/**
	 * fournis -> fournis
	 */
	protected void unbind(PortConfigurationFournis portConfiguration, PortComposantFournis portComposant) {
		portConfiguration.removeObserver(this);
		bindings.removeIf(binding -> binding.getFrom() == portConfiguration && binding.getTo() == portComposant);
	}
	
}
