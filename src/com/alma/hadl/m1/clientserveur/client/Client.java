package com.alma.hadl.m1.clientserveur.client;

import com.alma.hadl.m2.composant.Composant;

public class Client extends Composant {

	public Client(ClientEnvoyerRequete envoyerRequete, ClientRecevoirReponse recevoirReponse) {
		this.ajouterPortRequis(envoyerRequete);
		this.ajouterPortFournis(recevoirReponse);
	}
	
}
