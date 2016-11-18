package com.alma.hadl.m1.clientserver.serverdetails.database;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class Database extends Composant {
	
	public Database(PortComposantRequis sendDBQueryResponse,
			PortComposantRequis sendCQueryResponse,
			PortComposantFournis receiveDBQueryRequest,
			PortComposantFournis receiveCQueryRequest) {
		this.ajouterPortRequis("SendDBQueryResponse", sendDBQueryResponse);
		this.ajouterPortRequis("SendCQueryResponse", sendCQueryResponse);
		this.ajouterPortFournis("ReceiveDBQueryRequest", receiveDBQueryRequest);
		this.ajouterPortFournis("ReceiveCQueryRequest", receiveCQueryRequest);
	}
	
}
