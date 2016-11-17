package com.alma.hadl.m1.clientserver.serverdetails.connection;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class ConnectionManager extends Composant {
	
	public ConnectionManager(PortComposantFournis receiveExternalSocketRequest,
			PortComposantRequis sendExternalSocketResponse,
			PortComposantFournis receiveDBQueryResponse,
			PortComposantRequis sendDBQueryRequest,
			PortComposantFournis receiveSecurityCheckResponse,
			PortComposantRequis sendSecurityCheckRequest) {
		this.ajouterPortFournis("ReceiveExternalSocketRequest", receiveExternalSocketRequest);
		this.ajouterPortRequis("SendExternalSocketResponse", sendExternalSocketResponse);
		this.ajouterPortFournis("ReceiveDBQueryResponse", receiveDBQueryResponse);
		this.ajouterPortRequis("SendDBQueryRequest", sendDBQueryRequest);
		this.ajouterPortFournis("ReceiveSecurityCheckResponse", receiveSecurityCheckResponse);
		this.ajouterPortRequis("SendSecurityCheckRequest", sendSecurityCheckRequest);
	}

}
