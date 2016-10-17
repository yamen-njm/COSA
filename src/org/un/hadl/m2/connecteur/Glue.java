package org.un.hadl.m2.connecteur;

public class Glue {

	private RoleRequis roleRequis;
	private RoleFournis roleFournis;
	
	public Glue(RoleRequis roleRequis, RoleFournis roleFournis) {
		this.roleRequis = roleRequis;
		this.roleFournis = roleFournis;
	}
	
	public RoleRequis getRoleRequis() {
		return roleRequis;
	}

	public RoleFournis getRoleFournis() {
		return roleFournis;
	}
}
