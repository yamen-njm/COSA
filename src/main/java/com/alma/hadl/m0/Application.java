package com.alma.hadl.m0;

import com.alma.hadl.m1.clientserver.ClientServer;
import com.alma.hadl.m1.clientserver.client.Client;
import com.alma.hadl.m1.clientserver.client.ReceiveResponse;
import com.alma.hadl.m1.clientserver.client.SendRequest;
import com.alma.hadl.m1.clientserver.rpc.SendResponseCaller;
import com.alma.hadl.m1.clientserver.rpc.SendRequestCaller;
import com.alma.hadl.m1.clientserver.rpc.RPC;
import com.alma.hadl.m1.clientserver.rpc.ReceiveResponseCalled;
import com.alma.hadl.m1.clientserver.rpc.ReceiveRequestCalled;
import com.alma.hadl.m1.clientserver.server.ReceiveRequest;
import com.alma.hadl.m1.clientserver.server.SendResponse;
import com.alma.hadl.m1.clientserver.server.Server;
import com.alma.hadl.m1.clientserver.serverdetails.ServerDetails;
import com.alma.hadl.m1.clientserver.serverdetails.clearance.ClearanceRequest;
import com.alma.hadl.m1.clientserver.serverdetails.clearance.ReceiveAuthRequestCalled;
import com.alma.hadl.m1.clientserver.serverdetails.clearance.ReceiveSecurityCheckResponseCalled;
import com.alma.hadl.m1.clientserver.serverdetails.clearance.SendAuthResponseCaller;
import com.alma.hadl.m1.clientserver.serverdetails.clearance.SendSecurityCheckRequestCaller;
import com.alma.hadl.m1.clientserver.serverdetails.connection.ConnectionManager;
import com.alma.hadl.m1.clientserver.serverdetails.connection.ConnectionPorts;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendDBQueryRequest;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendExternalSocketResponse;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendSecurityCheckRequest;
import com.alma.hadl.m1.clientserver.serverdetails.database.Database;
import com.alma.hadl.m1.clientserver.serverdetails.database.DatabasePorts;
import com.alma.hadl.m1.clientserver.serverdetails.database.SendCQueryResponse;
import com.alma.hadl.m1.clientserver.serverdetails.database.SendDBQueryResponse;
import com.alma.hadl.m1.clientserver.serverdetails.sql.ReceiveDBQueryRequestCalled;
import com.alma.hadl.m1.clientserver.serverdetails.sql.ReceiveDBQueryResponseCalled;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SQLRequest;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SendDBQueryRequestCaller;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SendDBQueryResponseCaller;
import com.alma.hadl.m1.clientserver.serverdetails.security.SecurityManager;
import com.alma.hadl.m1.clientserver.serverdetails.security.SecurityPorts;
import com.alma.hadl.m1.clientserver.serverdetails.security.SendAuthResponse;
import com.alma.hadl.m1.clientserver.serverdetails.security.SendCQueryRequest;
import com.alma.hadl.m1.clientserver.serverdetails.securityQuery.ReceiveCQueryRequestCalled;
import com.alma.hadl.m1.clientserver.serverdetails.securityQuery.ReceiveCQueryResponseCalled;
import com.alma.hadl.m1.clientserver.serverdetails.securityQuery.SecurityQuery;
import com.alma.hadl.m1.clientserver.serverdetails.securityQuery.SendCQueryRequestCaller;
import com.alma.hadl.m1.clientserver.serverdetails.securityQuery.SendCQueryResponseCaller;

public class Application {

	public static void main(String[] args) {
		
		//== Ports Client
		SendRequest clientSendRequest = new SendRequest();
		ReceiveResponse clientReceiveResponse = new ReceiveResponse();
		
		//== Client
		Client client = new Client(clientSendRequest, clientReceiveResponse);
		
		//== Ports Serveur
		SendResponse serveurSendResponse = new SendResponse();
		ReceiveRequest serveurReceiveRequest = new ReceiveRequest();
		
		//== Serveur
		Server serveur = new Server(serveurSendResponse, serveurReceiveRequest);
		
		//== Roles RPC
		SendRequestCaller sendRequestCaller = new SendRequestCaller();
		ReceiveRequestCalled receiveRequestCalled = new ReceiveRequestCalled();
		SendResponseCaller sendResponseCaller = new SendResponseCaller();
		ReceiveResponseCalled receiveResponseCalled = new ReceiveResponseCalled();
		
		//== RPC
		RPC rpc = new RPC(receiveRequestCalled,
				receiveResponseCalled,
				sendRequestCaller,
				sendResponseCaller);
		
		//== Ports Connection Manager
		SendExternalSocketResponse sendExternalSocketResponse = new SendExternalSocketResponse();
		SendDBQueryRequest sendDBQueryRequest = new SendDBQueryRequest();
		SendSecurityCheckRequest sendSecurityCheckRequest = new SendSecurityCheckRequest();
		ConnectionPorts connectionPorts = new ConnectionPorts();
		
		//== Connection Manager
		ConnectionManager connectionManager = new ConnectionManager(sendExternalSocketResponse,
				sendDBQueryRequest,
				sendSecurityCheckRequest,
				connectionPorts.getReceiveExternalSocketRequest(),
				connectionPorts.getReceiveDBQueryResponse(),
				connectionPorts.getReceiveSecurityCheckResponse());
		
		//== Ports Database
		SendDBQueryResponse sendDBQueryResponse = new SendDBQueryResponse();
		SendCQueryResponse sendCQueryResponse = new SendCQueryResponse();
		DatabasePorts databasePorts = new DatabasePorts();
		
		//== Database
		Database database = new Database(sendDBQueryResponse,
				sendCQueryResponse,
				databasePorts.getReceiveDBQueryRequest(),
				databasePorts.getReceiveCQueryRequest());
		
		//== Ports Security Manager
		SendAuthResponse sendAuthResponse = new SendAuthResponse();
		SendCQueryRequest sendCQueryRequest = new SendCQueryRequest();
		SecurityPorts securityPorts = new SecurityPorts();
		
		//== Security Manager
		SecurityManager securityManager = new SecurityManager(sendAuthResponse,
				sendCQueryRequest,
				securityPorts.getReceiveAuthRequest(),
				securityPorts.getReceiveCQueryResponse());
		
		//== Roles SQL Request
		ReceiveDBQueryResponseCalled receiveDBQueryResponseCalled = new ReceiveDBQueryResponseCalled();
		ReceiveDBQueryRequestCalled receiveDBQueryRequestCalled = new ReceiveDBQueryRequestCalled();
		SendDBQueryRequestCaller sendDBQueryRequestCaller = new SendDBQueryRequestCaller();
		SendDBQueryResponseCaller sendDBQueryResponseCaller = new SendDBQueryResponseCaller();
		
		//== SQL Request
		SQLRequest sqlRequest = new SQLRequest(receiveDBQueryRequestCalled,
				receiveDBQueryResponseCalled,
				sendDBQueryRequestCaller,
				sendDBQueryResponseCaller);
		
		//== Roles Clearance Request
		ReceiveSecurityCheckResponseCalled receiveSecurityCheckResponseCalled = new ReceiveSecurityCheckResponseCalled();
		ReceiveAuthRequestCalled receiveAuthRequestCalled = new ReceiveAuthRequestCalled();
		SendSecurityCheckRequestCaller sendSecurityCheckRequestCaller = new SendSecurityCheckRequestCaller();
		SendAuthResponseCaller sendAuthResponseCaller = new SendAuthResponseCaller();
		
		//== Clearance Request
		ClearanceRequest clearanceRequest = new ClearanceRequest(receiveSecurityCheckResponseCalled,
				receiveAuthRequestCalled,
				sendAuthResponseCaller,
				sendSecurityCheckRequestCaller);
		
		//== Role Security Query
		ReceiveCQueryResponseCalled receiveCQueryResponseCalled = new ReceiveCQueryResponseCalled();
		ReceiveCQueryRequestCalled receiveCQueryRequestCalled = new ReceiveCQueryRequestCalled();
		SendCQueryRequestCaller sendCQueryRequestCaller = new SendCQueryRequestCaller();
		SendCQueryResponseCaller sendCQueryResponseCaller = new SendCQueryResponseCaller();
		
		//== Security Query
		SecurityQuery securityQuery = new SecurityQuery(receiveCQueryRequestCalled,
				receiveCQueryResponseCalled,
				sendCQueryRequestCaller,
				sendCQueryResponseCaller);
		
		//== Configuration Client Server
		ServerDetails serverDetails = new ServerDetails(connectionManager,
				database,
				securityManager,
				sqlRequest,
				clearanceRequest,
				securityQuery);
		
		//== Bigu configurationuuuuu
		ClientServer cs = new ClientServer(client, serveur, rpc, serverDetails);
		
		cs.getPortRequis("SendRequest").call("Hello");
	}

}
