package org.un.hadl.m2.configuration;

import org.un.hadl.m2.composant.PortComposant;
import org.un.hadl.m2.composant.PortComposantFournis;
import org.un.hadl.m2.composant.PortComposantRequis;
import org.un.hadl.m2.connecteur.Role;
import org.un.hadl.m2.connecteur.RoleFournis;
import org.un.hadl.m2.connecteur.RoleRequis;

public class Attachement {

	private PortComposant portComposant;
	private Role role;
	
	public Attachement(PortComposantRequis portComposant, RoleFournis role) {
		this.portComposant = portComposant;
		this.role = role;
	}
	
	public Attachement(PortComposantFournis portComposant, RoleRequis role) {
		this.portComposant = portComposant;
		this.role = role;
	}
	
	public PortComposant getPortComposant() {
		return portComposant;
	}

	public Role getRole() {
		return role;
	}
	
}
