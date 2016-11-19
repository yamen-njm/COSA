package com.alma.hadl.m1.clientserver.serverdetails.securityQuery;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;

public class SecurityQuery extends Connecteur {

	public SecurityQuery(RoleRequis receiveCQueryRequestCalled,
			RoleRequis receiveCQueryResponseCalled,
			RoleFournis sendCQueryRequestCaller,
			RoleFournis sendCQueryResponseCaller) {
		this.ajouterRoles("ReceiveCQueryRequestCalled", receiveCQueryRequestCalled,
				"SendCQueryRequestCaller", sendCQueryRequestCaller);
		this.ajouterRoles("ReceiveCQueryResponseCalled", receiveCQueryResponseCalled,
				"SendCQueryResponseCaller", sendCQueryResponseCaller);
	}
	
}
