package edu.nantes.alma.m2.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.nantes.alma.m2.composant.PortComposantFournis;
import edu.nantes.alma.m2.composant.PortComposantRequis;
import edu.nantes.alma.m2.connecteur.RoleFournis;
import edu.nantes.alma.m2.connecteur.RoleRequis;
import edu.nantes.alma.m2.util.Observable;
import edu.nantes.alma.m2.util.Observer;

public abstract class Configuration implements Observer {
	
	private static Logger logger = LogManager.getLogger();

	private List<Attachement> attachements = new ArrayList<Attachement>();
	private List<Binding> bindings = new ArrayList<Binding>();
		
	private Map<String, PortConfigurationFournis> portsFournis = new HashMap<String, PortConfigurationFournis>();
	private Map<String, PortConfigurationRequis> portsRequis = new HashMap<String, PortConfigurationRequis>();
	
	protected void ajouterPortFournis(String nom, PortConfigurationFournis portFournis) {
		portsFournis.put(nom, portFournis);
	}
	
	protected void ajouterPortRequis(String nom, PortConfigurationRequis portRequis) {
		portsRequis.put(nom, portRequis);
	}
	
	public PortConfigurationFournis getPortFournis(String nom) {
		return portsFournis.get(nom);
	}
	
	public PortConfigurationRequis getPortRequis(String nom) {
		return portsRequis.get(nom);
	}
	
	@Override
	public void update(Observable observable, String message) {
		for (Attachement attachement : attachements) {
			if (attachement.getFrom() == observable) {
				logger.trace("[attachement]");
				//logger.trace("[attachement] {} <-> {}", attachement.getFrom().getClass().getName(), attachement.getTo().getClass().getName());
				attachement.getTo().call(message);
			}
		}
		
		for (Binding binding : bindings) {
			if (binding.getFrom() == observable) {
				logger.trace("[binding]");
				//logger.trace("[binding] {} :: {}", binding.getFrom().getClass().getName(), binding.getTo().getClass().getName());
				binding.getTo().call(message);
			}
		}
	}
	
	/**
	 * port PortComposantRequis <-> role fournis
	 * 
	 * @param portRequis
	 * @param roleFournis
	 */
	protected void attach(PortComposantRequis portRequis, RoleFournis roleFournis) {
		attachements.add(new Attachement(portRequis, roleFournis));
		portRequis.addObserver(this);
	}
	/**
	 * port PortConfigurationRequis <-> role fournis
	 * 
	 * @param portRequis
	 * @param roleFournis
	 */
	protected void attach(PortConfigurationRequis portRequis, RoleFournis roleFournis) {
		attachements.add(new Attachement(portRequis, roleFournis));
		portRequis.addObserver(this);
	}
	
	/**
	 * port PortComposantFournis <-> role requis
	 * 
	 * @param portFournis
	 * @param roleRequis
	 */
	protected void attach(PortComposantFournis portFournis, RoleRequis roleRequis) {
		attachements.add(new Attachement(roleRequis, portFournis));
		roleRequis.addObserver(this);
	}
	/**
	 * port PortConfigurationFournis <-> role requis
	 * 
	 * @param portFournis
	 * @param roleRequis
	 */
	protected void attach(PortConfigurationFournis portFournis, RoleRequis roleRequis) {
		attachements.add(new Attachement(roleRequis, portFournis));
		roleRequis.addObserver(this);
	}
	
	/**
	 * port PortComposantRequis <-/-> role fournis
	 * 
	 * @param portRequis
	 * @param roleFournis
	 */
	protected void detacher(PortComposantRequis portRequis, RoleFournis roleFournis) {
		portRequis.removeObserver(this);
		attachements.removeIf(attachement -> attachement.getFrom() == portRequis && attachement.getTo() == roleFournis);
	}
	
	/**ta
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
