package com.alma.hadl.m2.connecteur;

import com.alma.hadl.m2.util.Observable;
import com.alma.hadl.m2.util.Observer;

public class Glue implements Observer {

	private RoleRequis roleRequis;
	private RoleFournis roleFournis;
	
	public Glue(RoleRequis roleRequis, RoleFournis roleFournis) {
		roleFournis.addObserver(this);
		this.roleRequis = roleRequis;
		this.roleFournis = roleFournis;
	}

	@Override
	public void update(Observable observable, String message) {
		roleRequis.call(message);
	}
}
