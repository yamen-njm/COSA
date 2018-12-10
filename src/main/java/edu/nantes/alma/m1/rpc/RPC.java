package edu.nantes.alma.m1.rpc;

import edu.nantes.alma.m2.connecteur.Connecteur;
import edu.nantes.alma.m2.connecteur.RoleFournis;
import edu.nantes.alma.m2.connecteur.RoleRequis;

public class RPC extends Connecteur {
	
	public RPC() {
		this.ajouterRoles("ReceiveRequestCalled", new RoleRequis(),
				"SendRequestCaller", new RoleFournis());
		this.ajouterRoles("ReceiveResponseCalled", new RoleRequis(),
				"SendResponseCaller", new RoleFournis());
	}

}
