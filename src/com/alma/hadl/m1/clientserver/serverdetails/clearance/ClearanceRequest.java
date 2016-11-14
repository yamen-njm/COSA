package com.alma.hadl.m1.clientserver.serverdetails.clearance;

import com.alma.hadl.m2.connecteur.Connecteur;

public class ClearanceRequest extends Connecteur {
	
	public ClearanceRequest(SendSecurityCheckRequestCaller sendSecurityCheckRequestCaller,
			ReceiveSecurityCheckResponseCalled receiveSecurityCheckResponseCalled,
			SendAuthResponseCaller sendAuthResponseCaller,
			ReceiveAuthRequestCalled receiveAuthRequestCalled) {
		this.ajouterRoles(receiveAuthRequestCalled, sendSecurityCheckRequestCaller);
		this.ajouterRoles(receiveSecurityCheckResponseCalled, sendAuthResponseCaller);
	}

}
