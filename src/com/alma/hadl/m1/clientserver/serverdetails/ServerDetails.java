package com.alma.hadl.m1.clientserver.serverdetails;

import com.alma.hadl.m1.clientserver.serverdetails.connection.ConnectionManager;
import com.alma.hadl.m1.clientserver.serverdetails.database.Database;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SQLRequest;
import com.alma.hadl.m2.configuration.Configuration;
import com.alma.hadl.m2.configuration.PortConfigurationFournis;
import com.alma.hadl.m2.configuration.PortConfigurationRequis;

public class ServerDetails extends Configuration {
	
	public ServerDetails(ConnectionManager connectionManager,
			Database database,
			SQLRequest sqlRequest) {
		PortConfigurationFournis receiveRequest = new ReceiveRequest();
		PortConfigurationRequis sendResponse = new SendResponse();
		
		this.ajouterPortFournis(receiveRequest);
		this.ajouterPortRequis(sendResponse);
		
		this.bind(this.getPortFournis("ReceiveRequest"), connectionManager.getPortFournis("ReceiveExternalSocketRequest"));
		this.bind(this.getPortRequis("SendResponse"), connectionManager.getPortRequis("SendExternalSocketResponse"));
		
		this.attacher(connectionManager.getPortFournis("ReceiveDBQueryResponse"), sqlRequest.getRoleRequis("ReceiveDBQueryResponseCalled"));
		this.attacher(connectionManager.getPortRequis("SendDBQueryRequest"), sqlRequest.getRoleFournis("SendDBQueryRequestCaller"));
		this.attacher(database.getPortFournis("ReceiveDBQueryRequest"), sqlRequest.getRoleRequis("ReceiveDBQueryRequestCalled"));
		this.attacher(database.getPortRequis("SendDBQueryResponse"), sqlRequest.getRoleFournis("SendDBQueryResponseCaller"));
	}

}
