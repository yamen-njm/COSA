package com.alma.hadl.m1.clientserver.serverdetails.database;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class Database extends Composant {
	
	public Database(PortComposantFournis receiveDBQueryRequest,
			PortComposantRequis sendDBQueryResponse) {
		this.ajouterPortFournis("ReceiveDBQueryRequest", receiveDBQueryRequest);
		this.ajouterPortRequis("SendDBQueryResponse", sendDBQueryResponse);
	}
	
}
