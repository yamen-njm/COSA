package com.alma.hadl.m1.clientserver.serverdetails.database;

import com.alma.hadl.m2.composant.Composant;

public class Database extends Composant {
	
	public Database(SendDBQueryResponse sendDBQueryResponse,
			ReceiveDBQueryRequest receiveDBQueryRequest) {
		this.ajouterPortRequis(sendDBQueryResponse);
		this.ajouterPortFournis(receiveDBQueryRequest);
	}
	
}
