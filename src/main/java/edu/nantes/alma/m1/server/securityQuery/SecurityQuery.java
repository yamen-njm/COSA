package edu.nantes.alma.m1.server.securityQuery;

import edu.nantes.alma.m2.connecteur.Connecteur;
import edu.nantes.alma.m2.connecteur.RoleFournis;
import edu.nantes.alma.m2.connecteur.RoleRequis;

public class SecurityQuery extends Connecteur {

	public SecurityQuery() {
		this.ajouterRoles("ReceiveCQueryRequestCalled", new RoleRequis(),
				"SendCQueryRequestCaller", new RoleFournis());
		this.ajouterRoles("ReceiveCQueryResponseCalled", new RoleRequis(),
				"SendCQueryResponseCaller", new RoleFournis());
	}
	
}
