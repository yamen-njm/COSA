package com.alma.hadl.m1.clientserver.server;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.composant.PortComposantFournis;
import com.alma.hadl.m2.composant.PortComposantRequis;

public class Server extends Composant {

	public Server(PortComposantFournis receiveResponse, PortComposantRequis sendResponse) {
		this.ajouterPortFournis("ReceiveRequest", receiveResponse);
		this.ajouterPortRequis("SendResponse", sendResponse);
	}
	
}
