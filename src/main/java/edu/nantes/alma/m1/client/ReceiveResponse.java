package edu.nantes.alma.m1.client;

import edu.nantes.alma.m2.composant.PortComposantFournis;

public class ReceiveResponse extends PortComposantFournis {

	@Override
	protected void execute(String message) {
		System.out.println("Reception de la reponse: " + message);
	}

}
