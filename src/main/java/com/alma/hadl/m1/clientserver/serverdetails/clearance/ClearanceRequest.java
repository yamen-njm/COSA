package com.alma.hadl.m1.clientserver.serverdetails.clearance;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;

public class ClearanceRequest extends Connecteur {
	
	public ClearanceRequest(RoleRequis receiveSecurityCheckResponseCalled,
			RoleRequis receiveAuthRequestCalled,
			RoleFournis sendSecurityCheckRequestCaller,
			RoleFournis sendAuthResponseCaller) {
		this.ajouterRoles("ReceiveSecurityCheckResponseCalled", receiveSecurityCheckResponseCalled,
				"SendSecurityCheckRequestCaller", sendSecurityCheckRequestCaller);
		this.ajouterRoles("ReceiveAuthRequestCalled", receiveAuthRequestCalled,
				"SendAuthResponseCaller", sendAuthResponseCaller);
	}

}
