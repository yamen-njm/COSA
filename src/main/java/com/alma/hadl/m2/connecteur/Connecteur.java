package com.alma.hadl.m2.connecteur;

import java.util.ArrayList;
import java.util.List;

import com.alma.hadl.m2.util.Observable;
import com.alma.hadl.m2.util.Observer;

public abstract class Connecteur implements Observer {

	private List<Glue> glues = new ArrayList<Glue>();

	protected void ajouterRoles(String nomRoleRequis, RoleRequis roleRequis,
			String nomRoleFournis, RoleFournis roleFournis) {
		glues.add(new Glue(nomRoleRequis, roleRequis, nomRoleFournis, roleFournis));
		roleFournis.addObserver(this);
	}
	
	public RoleFournis getRoleFournis(String nom) {
		for (Glue glue : glues) {
			if (glue.getNomRoleFournis().equals(nom)) {
				return glue.getRoleFournis();
			}
		}
		
		return null;
	}
	
	public RoleRequis getRoleRequis(String nom) {
		for (Glue glue : glues) {
			if (glue.getNomRoleRequis().equals(nom)) {
				return glue.getRoleRequis();
			}
		}
		
		return null;
	}
	
	@Override
	public void update(Observable observable, String message) {
		for (Glue glue : glues) {
			if (glue.getRoleFournis() == observable) {
				glue.getRoleRequis().call(message);
			}
		}
	}
}
