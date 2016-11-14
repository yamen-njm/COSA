package com.alma.hadl.m1.clientserver.rpc;

import com.alma.hadl.m2.connecteur.Connecteur;

public class RPC extends Connecteur {
	
	public RPC(SendRequestCaller sendRequestCaller,
			ReceiveRequestCalled receiveRequestCalled,
			SendResponseCaller sendResponseCaller,
			ReceiveResponseCalled receiveResponseCalled) {
		
		this.ajouterRoles(receiveRequestCalled, sendRequestCaller);
		this.ajouterRoles(receiveResponseCalled, sendResponseCaller);
	}

}
