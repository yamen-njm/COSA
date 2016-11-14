package com.alma.hadl.m1.clientserver.server;

import com.alma.hadl.m2.composant.Composant;

public class Server extends Composant {

	public Server(SendResponse sendResponse, ReceiveRequest receiveResponse) {
		this.ajouterPortRequis(sendResponse);
		this.ajouterPortFournis(receiveResponse);
	}
	
}
