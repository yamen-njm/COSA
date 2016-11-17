package com.alma.hadl.m1.clientserver.client;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class Client extends Composant {

	public Client(PortComposantFournis receiveResponse, PortComposantRequis sendRequest) {
		this.ajouterPortFournis("ReceiveResponse", receiveResponse);
		this.ajouterPortRequis("SendRequest", sendRequest);
	}
	
}
