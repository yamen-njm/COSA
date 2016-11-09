package com.alma.hadl.m1.clientserveur.serveur;

import com.alma.hadl.m2.composant.Composant;

public class Serveur extends Composant {

	public Serveur(ServeurEnvoyerReponse envoyerReponse, ServeurRecevoirRequete recevoirRequete) {
		this.ajouterPortRequis(envoyerReponse);
		this.ajouterPortFournis(recevoirRequete);
	}
	
}
