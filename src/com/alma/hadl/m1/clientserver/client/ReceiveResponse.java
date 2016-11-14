package com.alma.hadl.m1.clientserver.client;

import com.alma.hadl.m2.composant.PortComposantFournis;

public class ReceiveResponse extends PortComposantFournis {

	@Override
	protected void execute(String message) {
		System.out.println("Reception de la reponse: " + message);
	}

}
