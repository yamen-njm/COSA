package com.alma.hadl.m1.clientserver.serverdetails.connection;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class ConnectionManager extends Composant {
	
	public ConnectionManager(PortComposantRequis sendExternalSocketResponse,
			PortComposantRequis sendDBQueryRequest,
			PortComposantRequis sendSecurityCheckRequest,
			PortComposantFournis receiveExternalSocketRequest,
			PortComposantFournis receiveDBQueryResponse,
			PortComposantFournis receiveSecurityCheckResponse) {
		this.ajouterPortRequis("SendExternalSocketResponse", sendExternalSocketResponse);
		this.ajouterPortRequis("SendDBQueryRequest", sendDBQueryRequest);
		this.ajouterPortRequis("SendSecurityCheckRequest", sendSecurityCheckRequest);
		this.ajouterPortFournis("ReceiveExternalSocketRequest", receiveExternalSocketRequest);
		this.ajouterPortFournis("ReceiveDBQueryResponse", receiveDBQueryResponse);
		this.ajouterPortFournis("ReceiveSecurityCheckResponse", receiveSecurityCheckResponse);
	}

}
