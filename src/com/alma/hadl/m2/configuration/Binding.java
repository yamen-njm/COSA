package com.alma.hadl.m2.configuration;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;
import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;
import com.alma.hadl.m2.util.Observer;

public class Binding implements Observer {
	
	private Callable to;

	protected Binding(PortComposantRequis portComposant, PortConfigurationRequis portConfiguration) {
		portComposant.addObserver(this);
		this.to = portConfiguration;
	}
	
	protected Binding(PortComposantFournis portComposant, PortConfigurationFournis portConfiguration) {
		portComposant.addObserver(this);
		this.to = portConfiguration;
	}
	
	protected Binding(PortConfigurationRequis portConfiguration, PortComposantRequis portComposant) {
		portConfiguration.addObserver(this);
		this.to = portComposant;
	}
	
	protected Binding(PortConfigurationFournis portConfiguration, PortComposantFournis portComposant) {
		portConfiguration.addObserver(this);
		this.to = portComposant;
	}
	
	@Override
	public void update(Observable observable, String message) {
		to.call(message);
	}
	
}
