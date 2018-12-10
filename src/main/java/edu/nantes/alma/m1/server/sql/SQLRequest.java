package edu.nantes.alma.m1.server.sql;

import edu.nantes.alma.m2.connecteur.Connecteur;
import edu.nantes.alma.m2.connecteur.RoleFournis;
import edu.nantes.alma.m2.connecteur.RoleRequis;

public class SQLRequest extends Connecteur {

	public SQLRequest() {
		this.ajouterRoles("ReceiveDBQueryRequestCalled", new RoleRequis(),
				"SendDBQueryRequestCaller", new RoleFournis());
		this.ajouterRoles("ReceiveDBQueryResponseCalled", new RoleRequis(),
				"SendDBQueryResponseCaller", new RoleFournis());
	}
	
}
