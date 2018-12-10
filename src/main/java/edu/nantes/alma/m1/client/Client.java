package edu.nantes.alma.m1.client;

import edu.nantes.alma.m2.composant.Composant;
import edu.nantes.alma.m2.composant.PortComposantFournis;
import edu.nantes.alma.m2.composant.PortComposantRequis;

public class Client extends Composant {

	public Client() {
		this.ajouterPortFournis("ReceiveResponse",new ReceiveResponse());
		this.ajouterPortRequis("SendRequest", new SendRequest());
	}
	
}
