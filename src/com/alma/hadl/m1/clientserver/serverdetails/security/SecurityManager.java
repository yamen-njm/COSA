package com.alma.hadl.m1.clientserver.serverdetails.security;

import com.alma.hadl.m2.composant.Composant;

public class SecurityManager extends Composant {
	
	public SecurityManager(ReceiveAuthRequest receiveAuthRequest, SendAuthResponse sendAuthResponse) {
		this.ajouterPortFournis(receiveAuthRequest);
		this.ajouterPortRequis(sendAuthResponse);
	}

}
