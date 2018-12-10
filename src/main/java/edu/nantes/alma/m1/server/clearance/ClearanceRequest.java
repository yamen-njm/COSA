package edu.nantes.alma.m1.server.clearance;

import edu.nantes.alma.m2.connecteur.Connecteur;
import edu.nantes.alma.m2.connecteur.RoleFournis;
import edu.nantes.alma.m2.connecteur.RoleRequis;

public class ClearanceRequest extends Connecteur {
	
	public ClearanceRequest() {
		this.ajouterRoles("ReceiveSecurityCheckResponseCalled", new RoleRequis(),
				"SendAuthResponseCaller", new RoleFournis());
		this.ajouterRoles("ReceiveAuthRequestCalled", new RoleRequis(),
				"SendSecurityCheckRequestCaller", new RoleFournis());
	}

}
