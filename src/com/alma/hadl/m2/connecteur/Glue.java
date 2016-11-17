package com.alma.hadl.m2.connecteur;

public class Glue {
	
	private String nomRoleRequis;
	private String nomRoleFournis;
	
	private RoleRequis roleRequis;
	private RoleFournis roleFournis;
	
	public Glue(String nomRoleRequis, RoleRequis roleRequis,
			String nomRoleFournis, RoleFournis roleFournis) {
		this.nomRoleRequis = nomRoleRequis;
		this.nomRoleFournis = nomRoleFournis;
		
		this.roleFournis = roleFournis;
		this.roleRequis = roleRequis;
	}
	
	public RoleRequis getRoleRequis() {
		return roleRequis;
	}

	public RoleFournis getRoleFournis() {
		return roleFournis;
	}
	
	public String getNomRoleRequis() {
		return nomRoleRequis;
	}

	public String getNomRoleFournis() {
		return nomRoleFournis;
	}


}
