package edu.nantes.alma.m1.server.security;

import edu.nantes.alma.m2.composant.Composant;
import edu.nantes.alma.m2.composant.PortComposantRequis;

public class SecurityManager extends Composant {
	
	public SecurityManager() {
		SecurityPorts securityPorts = new SecurityPorts();
		this.ajouterPortRequis("SendAuthResponse", new PortComposantRequis());
		this.ajouterPortRequis("SendCQueryRequest", new PortComposantRequis());
		this.ajouterPortFournis("ReceiveAuthRequest", securityPorts.getReceiveAuthRequest());
		this.ajouterPortFournis("ReceiveCQueryResponse", securityPorts.getReceiveCQueryResponse());
	}

}
