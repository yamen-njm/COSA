package com.alma.hadl.m2.connecteur;

import java.util.HashMap;
import java.util.Map;

public class Connecteur {

	private Map<String, RoleFournis> rolesFournis = new HashMap<String, RoleFournis>();
	private Map<String, RoleRequis> rolesRequis = new HashMap<String, RoleRequis>();
	
	protected Connecteur() {
	}

	protected void ajouterRoleFournis(RoleFournis roleFournis) {
		rolesFournis.put(roleFournis.getNom(), roleFournis);
	}
	
	protected void ajouterRoleRequis(RoleRequis roleRequis) {
		rolesRequis.put(roleRequis.getNom(), roleRequis);
	}
	
	public RoleFournis getRoleFournis(String nom) {
		return rolesFournis.get(nom);
	}
	
	public RoleRequis getRoleRequis(String nom) {
		return rolesRequis.get(nom);
	}
}
