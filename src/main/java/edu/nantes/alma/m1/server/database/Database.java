package edu.nantes.alma.m1.server.database;

import edu.nantes.alma.m2.composant.Composant;
import edu.nantes.alma.m2.composant.PortComposantFournis;
import edu.nantes.alma.m2.composant.PortComposantRequis;

public class Database extends Composant {
	
	public Database() {
		DatabasePorts databasePorts = new DatabasePorts();
		this.ajouterPortRequis("SendDBQueryResponse", new PortComposantRequis());
		this.ajouterPortRequis("SendCQueryResponse", new PortComposantRequis());
		this.ajouterPortFournis("ReceiveDBQueryRequest", databasePorts.getReceiveDBQueryRequest());
		this.ajouterPortFournis("ReceiveCQueryRequest", databasePorts.getReceiveCQueryRequest());
	}
	
}
