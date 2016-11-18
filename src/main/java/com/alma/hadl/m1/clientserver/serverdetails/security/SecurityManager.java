package com.alma.hadl.m1.clientserver.serverdetails.security;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class SecurityManager extends Composant {
	
	public SecurityManager(PortComposantRequis sendAuthResponse,
			PortComposantRequis sendCQueryRequest,
			PortComposantFournis receiveAuthRequest,
			PortComposantFournis receiveCQueryResponse) {
		this.ajouterPortRequis("SendAuthResponse", sendAuthResponse);
		this.ajouterPortRequis("SendCQueryRequest", sendCQueryRequest);
		this.ajouterPortFournis("ReceiveAuthRequest", receiveAuthRequest);
		this.ajouterPortFournis("ReceiveCQueryResponse", receiveCQueryResponse);
	}

}
