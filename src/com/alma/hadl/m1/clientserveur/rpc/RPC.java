package com.alma.hadl.m1.clientserveur.rpc;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.Glue;

public class RPC extends Connecteur {
	
	public RPC(RecevoirReponseCalled recevoirReponseCalled, RecevoirRequeteCalled recevoirRequeteCalled, EnvoyerRequeteCaller envoyerRequeteCaller, EnvoyerReponseCaller envoyerReponseCaller) {
		this.ajouterRoleRequis(recevoirReponseCalled);
		this.ajouterRoleRequis(recevoirRequeteCalled);
		this.ajouterRoleFournis(envoyerRequeteCaller);
		this.ajouterRoleFournis(envoyerReponseCaller);
		
		new Glue(recevoirRequeteCalled, envoyerRequeteCaller);
		new Glue(recevoirReponseCalled, envoyerReponseCaller);
	}

}
