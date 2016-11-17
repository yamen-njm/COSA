package com.alma.hadl.m1.clientserver.serverdetails.clearance;

import com.alma.hadl.m2.connecteur.Connecteur;

public class ClearanceRequest extends Connecteur {
	
	public ClearanceRequest(SendSecurityCheckRequestCaller sendSecurityCheckRequestCaller,
			ReceiveSecurityCheckResponseCalled receiveSecurityCheckResponseCalled,
			SendAuthResponseCaller sendAuthResponseCaller,
			ReceiveAuthRequestCalled receiveAuthRequestCalled) {
		this.ajouterRoles("ReceiveSecurityCheckResponseCalled", receiveSecurityCheckResponseCalled,
				"SendSecurityCheckRequestCaller", sendSecurityCheckRequestCaller);
		this.ajouterRoles("ReceiveAuthRequestCalled", receiveAuthRequestCalled,
				"SendAuthResponseCaller", sendAuthResponseCaller);
	}

}
