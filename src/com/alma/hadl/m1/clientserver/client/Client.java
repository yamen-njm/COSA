package com.alma.hadl.m1.clientserver.client;

import com.alma.hadl.m2.composant.Composant;

public class Client extends Composant {

	public Client(SendRequest sendRequest, ReceiveResponse receiveResponse) {
		this.ajouterPortRequis(sendRequest);
		this.ajouterPortFournis(receiveResponse);
	}
	
}
