package edu.nantes.alma.m1.server;

import edu.nantes.alma.m1.server.clearance.ClearanceRequest;
import edu.nantes.alma.m1.server.connection.ConnectionManager;
import edu.nantes.alma.m1.server.database.Database;
import edu.nantes.alma.m1.server.security.SecurityManager;
import edu.nantes.alma.m1.server.securityQuery.SecurityQuery;
import edu.nantes.alma.m1.server.sql.SQLRequest;
import edu.nantes.alma.m2.configuration.Configuration;
import edu.nantes.alma.m2.configuration.PortConfigurationFournis;
import edu.nantes.alma.m2.configuration.PortConfigurationRequis;

public class Server extends Configuration {
	
	public Server() {
				//== Connection Manager
				ConnectionManager connectionManager = new ConnectionManager();
				//== Database
				Database database = new Database();
				//== Security Manager
				SecurityManager securityManager = new SecurityManager();
				//== SQL Request
				SQLRequest sqlRequest = new SQLRequest();
				//== Clearance Request
				ClearanceRequest clearanceRequest = new ClearanceRequest();
				//== Security Query
				SecurityQuery securityQuery = new SecurityQuery();
		//making the required attachments and bindings
		this.ajouterPortRequis("SendResponse", new PortConfigurationRequis());
		this.ajouterPortFournis("ReceiveRequest", new PortConfigurationFournis());
		
		this.bind(this.getPortFournis("ReceiveRequest"),
				connectionManager.getPortFournis("ReceiveExternalSocketRequest"));
		this.bind(connectionManager.getPortRequis("SendExternalSocketResponse"),
				this.getPortRequis("SendResponse"));
		
		this.attach(connectionManager.getPortFournis("ReceiveDBQueryResponse"),
				sqlRequest.getRoleRequis("ReceiveDBQueryResponseCalled"));
		this.attach(connectionManager.getPortRequis("SendDBQueryRequest"),
				sqlRequest.getRoleFournis("SendDBQueryRequestCaller"));
		this.attach(database.getPortFournis("ReceiveDBQueryRequest"),
				sqlRequest.getRoleRequis("ReceiveDBQueryRequestCalled"));
		this.attach(database.getPortRequis("SendDBQueryResponse"),
				sqlRequest.getRoleFournis("SendDBQueryResponseCaller"));
		
		this.attach(connectionManager.getPortFournis("ReceiveSecurityCheckResponse"),
				clearanceRequest.getRoleRequis("ReceiveSecurityCheckResponseCalled"));
		this.attach(connectionManager.getPortRequis("SendSecurityCheckRequest"),
				clearanceRequest.getRoleFournis("SendSecurityCheckRequestCaller"));
		this.attach(securityManager.getPortFournis("ReceiveAuthRequest"),
				clearanceRequest.getRoleRequis("ReceiveAuthRequestCalled"));
		this.attach(securityManager.getPortRequis("SendAuthResponse"),
				clearanceRequest.getRoleFournis("SendAuthResponseCaller"));

		this.attach(database.getPortRequis("SendCQueryResponse"),
				securityQuery.getRoleFournis("SendCQueryResponseCaller"));
		this.attach(database.getPortFournis("ReceiveCQueryRequest"),
				securityQuery.getRoleRequis("ReceiveCQueryRequestCalled"));
		this.attach(securityManager.getPortRequis("SendCQueryRequest"),
				securityQuery.getRoleFournis("SendCQueryRequestCaller"));
		this.attach(securityManager.getPortFournis("ReceiveCQueryResponse"),
				securityQuery.getRoleRequis("ReceiveCQueryResponseCalled"));
	}

}
