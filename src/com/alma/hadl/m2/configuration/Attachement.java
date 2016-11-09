package com.alma.hadl.m2.configuration;

import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;
import com.alma.hadl.m2.util.Callable;
import com.alma.hadl.m2.util.Observable;
import com.alma.hadl.m2.util.Observer;

public class Attachement implements Observer {

	private Callable to;
	
	public Attachement(PortComposantRequis portComposantRequis, RoleFournis roleFournis) {
		portComposantRequis.addObserver(this);
		this.to = roleFournis;
	}
	
	public Attachement(PortComposantFournis portComposantFournis, RoleRequis roleRequis) {
		roleRequis.addObserver(this);
		this.to = portComposantFournis;
	}

	@Override
	public void update(Observable observable, String message) {
		to.call(message);
	}
	
}
