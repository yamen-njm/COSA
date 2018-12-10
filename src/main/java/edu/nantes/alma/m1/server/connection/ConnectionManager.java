package edu.nantes.alma.m1.server.connection;

import edu.nantes.alma.m2.composant.Composant;
import edu.nantes.alma.m2.composant.PortComposantFournis;
import edu.nantes.alma.m2.composant.PortComposantRequis;

public class ConnectionManager extends Composant {
	
	public ConnectionManager() {
		ConnectionPorts connectionPorts = new ConnectionPorts();
		this.ajouterPortRequis("SendExternalSocketResponse", new PortComposantRequis());
		this.ajouterPortRequis("SendDBQueryRequest", new PortComposantRequis());
		this.ajouterPortRequis("SendSecurityCheckRequest", new PortComposantRequis());
		this.ajouterPortFournis("ReceiveExternalSocketRequest", connectionPorts.getReceiveExternalSocketRequest());
		this.ajouterPortFournis("ReceiveDBQueryResponse", connectionPorts.getReceiveDBQueryResponse());
		this.ajouterPortFournis("ReceiveSecurityCheckResponse", connectionPorts.getReceiveSecurityCheckResponse());
	}

}
