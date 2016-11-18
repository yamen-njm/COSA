package com.alma.hadl.m1.clientserver.serverdetails.securityQuery;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;

public class SecurityQuery extends Connecteur {

	public SecurityQuery(RoleRequis receiveCQueryResponseCalled,
			RoleRequis receiveCQueryRequestCalled,
			RoleFournis sendCQueryRequestCaller,
			RoleFournis sendCQueryResponseCaller) {
		this.ajouterRoles("ReceiveCQueryResponseCalled", receiveCQueryResponseCalled,
				"SendCQueryRequestCaller", sendCQueryRequestCaller);
		this.ajouterRoles("ReceiveCQueryRequestCalled", receiveCQueryRequestCalled,
				"SendCQueryResponseCaller", sendCQueryResponseCaller);
	}
	
}
