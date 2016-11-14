package com.alma.hadl.m1.clientserver.serverdetails.sql;

import com.alma.hadl.m2.connecteur.Connecteur;

public class SQLRequest extends Connecteur {

	public SQLRequest(SendDBQueryRequestCaller sendDBQueryRequestCaller,
			ReceiveDBQueryResponseCalled receiveDBQueryResponseCalled,
			SendDBQueryResponseCaller sendDBQueryResponseCaller,
			ReceiveDBQueryRequestCalled receiveDBQueryRequestCalled) {
		this.ajouterRoles(receiveDBQueryResponseCalled, sendDBQueryRequestCaller);
		this.ajouterRoles(receiveDBQueryRequestCalled, sendDBQueryResponseCaller);
	}
	
}
