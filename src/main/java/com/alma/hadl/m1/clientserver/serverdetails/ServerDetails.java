package com.alma.hadl.m1.clientserver.serverdetails;

import com.alma.hadl.m2.composant.Composant;
import com.alma.hadl.m2.configuration.Configuration;
import com.alma.hadl.m2.configuration.PortConfigurationFournis;
import com.alma.hadl.m2.configuration.PortConfigurationRequis;
import com.alma.hadl.m2.connecteur.Connecteur;

public class ServerDetails extends Configuration {
	
	public ServerDetails(Composant connectionManager,
			Composant database,
			Composant securityManager,
			Connecteur sqlRequest,
			Connecteur clearanceRequest) {
		PortConfigurationFournis receiveRequest = new ReceiveRequest();
		PortConfigurationRequis sendResponse = new SendResponse();
		
		this.ajouterPortFournis("ReceiveRequest", receiveRequest);
		this.ajouterPortRequis("SendResponse", sendResponse);
		
		this.bind(this.getPortFournis("ReceiveRequest"),
				connectionManager.getPortFournis("ReceiveExternalSocketRequest"));
		this.bind(this.getPortRequis("SendResponse"),
				connectionManager.getPortRequis("SendExternalSocketResponse"));
		
		this.attacher(connectionManager.getPortFournis("ReceiveDBQueryResponse"),
				sqlRequest.getRoleRequis("ReceiveDBQueryResponseCalled"));
		this.attacher(connectionManager.getPortRequis("SendDBQueryRequest"),
				sqlRequest.getRoleFournis("SendDBQueryRequestCaller"));
		this.attacher(database.getPortFournis("ReceiveDBQueryRequest"),
				sqlRequest.getRoleRequis("ReceiveDBQueryRequestCalled"));
		this.attacher(database.getPortRequis("SendDBQueryResponse"),
				sqlRequest.getRoleFournis("SendDBQueryResponseCaller"));
		
		this.attacher(connectionManager.getPortFournis("ReceiveSecurityCheckResponse"),
				clearanceRequest.getRoleRequis("ReceiveSecurityCheckResponseCalled"));
		this.attacher(connectionManager.getPortRequis("SendSecurityCheckRequest"),
				clearanceRequest.getRoleFournis("SendSecurityCheckRequestCaller"));
		this.attacher(securityManager.getPortFournis("ReceiveAuthRequest"),
				clearanceRequest.getRoleRequis("ReceiveAuthRequestCalled"));
		this.attacher(securityManager.getPortRequis("SendAuthResponse"),
				clearanceRequest.getRoleFournis("SendAuthResponseCaller"));

		
	}

}