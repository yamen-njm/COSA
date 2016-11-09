package com.alma.hadl.m1.clientserveur;

import com.alma.hadl.m1.clientserveur.client.Client;
import com.alma.hadl.m1.clientserveur.rpc.RPC;
import com.alma.hadl.m1.clientserveur.serveur.Serveur;
import com.alma.hadl.m2.configuration.Attachement;
import com.alma.hadl.m2.configuration.Configuration;

/**
 * Created by sidali on 17/10/2016.
 */
public class ClientServeurConfiguration extends Configuration {
			
	public ClientServeurConfiguration(Client client, Serveur serveur, RPC rpc) {
		new Attachement(client.getPortRequis("ClientEnvoyerRequete"), rpc.getRoleFournis("EnvoyerRequeteCaller"));
		new Attachement(client.getPortFournis("ClientRecevoirReponse"), rpc.getRoleRequis("RecevoirReponseCalled"));
		new Attachement(serveur.getPortRequis("ServeurEnvoyerReponse"), rpc.getRoleFournis("EnvoyerReponseCaller"));
		new Attachement(serveur.getPortFournis("ServeurRecevoirRequete"), rpc.getRoleRequis("RecevoirRequeteCalled"));
	}
	
}
