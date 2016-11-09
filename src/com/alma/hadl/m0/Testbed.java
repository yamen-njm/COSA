package com.alma.hadl.m0;

import java.util.Observable;
import java.util.Observer;

import com.alma.hadl.m1.clientserveur.ClientServeurConfiguration;
import com.alma.hadl.m1.clientserveur.client.Client;
import com.alma.hadl.m1.clientserveur.client.ClientEnvoyerRequete;
import com.alma.hadl.m1.clientserveur.client.ClientRecevoirReponse;
import com.alma.hadl.m1.clientserveur.rpc.EnvoyerReponseCaller;
import com.alma.hadl.m1.clientserveur.rpc.EnvoyerRequeteCaller;
import com.alma.hadl.m1.clientserveur.rpc.RPC;
import com.alma.hadl.m1.clientserveur.rpc.RecevoirReponseCalled;
import com.alma.hadl.m1.clientserveur.rpc.RecevoirRequeteCalled;
import com.alma.hadl.m1.clientserveur.serveur.Serveur;
import com.alma.hadl.m1.clientserveur.serveur.ServeurEnvoyerReponse;
import com.alma.hadl.m1.clientserveur.serveur.ServeurRecevoirRequete;
import com.alma.hadl.m2.util.Callable;

public class Testbed {

	public static void main(String[] args) {
		
		//== Ports Client
		ClientEnvoyerRequete clientEnvoyerRequete = new ClientEnvoyerRequete();
		ClientRecevoirReponse clientRecevoirReponse = new ClientRecevoirReponse(new Callable() {
			@Override
			public void call(String message) {
				System.out.println("Client: Reponse recu: " + message);
			}
		});
		
		//== Client
		Client client = new Client(clientEnvoyerRequete, clientRecevoirReponse);
		
		//== Ports Serveur
		ServeurEnvoyerReponse serveurEnoyerReponse = new ServeurEnvoyerReponse();
		ServeurRecevoirRequete serveurRecevoirRequete = new ServeurRecevoirRequete(new Callable() {
			@Override
			public void call(String message) {
				System.out.println("Serveur: Requete recu: " + message);
				serveurEnoyerReponse.call("Ta Super Requete");
			}
		});
		
		//== Serveur
		Serveur serveur = new Serveur(serveurEnoyerReponse, serveurRecevoirRequete);
		
		// Roles RPC
		EnvoyerRequeteCaller envoyerRequeteCaller = new EnvoyerRequeteCaller(new Callable() {
			@Override
			public void call(String message) {
			}
		});
		RecevoirRequeteCalled recevoirRequeteCalled = new RecevoirRequeteCalled();
		EnvoyerReponseCaller envoyerReponseCaller = new EnvoyerReponseCaller(new Callable() {
			@Override
			public void call(String message) {
			}
		});
		RecevoirReponseCalled recevoirReponseCalled = new RecevoirReponseCalled();
		
		// RPC
		RPC rpc = new RPC(recevoirReponseCalled, recevoirRequeteCalled, envoyerRequeteCaller, envoyerReponseCaller);
		
		//== Bigu configurationuuuuu
		ClientServeurConfiguration cs = new ClientServeurConfiguration(client, serveur, rpc);
		
		clientEnvoyerRequete.call("Ma Super Requete");
		
		//System.out.println(clientEnvoyerRequete.getNom());
	}

}
