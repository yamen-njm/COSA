package com.alma.hadl.m1.clientserver.serverdetails.connection;

import com.alma.hadl.m2.composant.Composant;

public class ConnectionManager extends Composant {
	
	public ConnectionManager(ReceiveExternalSocketRequest receiveExternalSocketRequest,
			SendExternalSocketResponse sendExternalSocketResponse,
			ReceiveDBQueryResponse receiveDBQueryResponse,
			SendDBQueryRequest sendDBQueryRequest) {
		this.ajouterPortFournis(receiveExternalSocketRequest);
		this.ajouterPortRequis(sendExternalSocketResponse);
		this.ajouterPortFournis(receiveDBQueryResponse);
		this.ajouterPortRequis(sendDBQueryRequest);
	}

}