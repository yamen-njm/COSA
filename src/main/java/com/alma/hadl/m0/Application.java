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
import com.alma.hadl.m1.clientserver.serverdetails.connection.ReceiveDBQueryResponse;
import com.alma.hadl.m1.clientserver.serverdetails.connection.ReceiveExternalSocketRequest;
import com.alma.hadl.m1.clientserver.serverdetails.connection.ReceiveSecurityCheckResponse;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendDBQueryRequest;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendExternalSocketResponse;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendSecurityCheckRequest;
import com.alma.hadl.m1.clientserver.serverdetails.database.Database;
import com.alma.hadl.m1.clientserver.serverdetails.database.ReceiveDBQueryRequest;
import com.alma.hadl.m1.clientserver.serverdetails.database.SendDBQueryResponse;
import com.alma.hadl.m1.clientserver.serverdetails.sql.ReceiveDBQueryRequestCalled;
import com.alma.hadl.m1.clientserver.serverdetails.sql.ReceiveDBQueryResponseCalled;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SQLRequest;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SendDBQueryRequestCaller;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SendDBQueryResponseCaller;
import com.alma.hadl.m1.clientserver.serverdetails.security.ReceiveAuthRequest;
import com.alma.hadl.m1.clientserver.serverdetails.security.SecurityManager;
import com.alma.hadl.m1.clientserver.serverdetails.security.SendAuthResponse;

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
		ReceiveExternalSocketRequest receiveExternalSocketRequest = new ReceiveExternalSocketRequest();
		SendExternalSocketResponse sendExternalSocketResponse = new SendExternalSocketResponse();
		SendDBQueryRequest sendDBQueryRequest = new SendDBQueryRequest();
		ReceiveDBQueryResponse receiveDBQueryResponse = new ReceiveDBQueryResponse();
		ReceiveSecurityCheckResponse receiveSecurityCheckResponse = new ReceiveSecurityCheckResponse();
		SendSecurityCheckRequest sendSecurityCheckRequest = new SendSecurityCheckRequest();
		
		//== Connection Manager
		ConnectionManager connectionManager = new ConnectionManager(sendExternalSocketResponse,
				sendDBQueryRequest,
				sendSecurityCheckRequest,
				receiveExternalSocketRequest,
				receiveDBQueryResponse,
				receiveSecurityCheckResponse);
		
		//== Ports Database
		SendDBQueryResponse sendDBQueryResponse = new SendDBQueryResponse();
		ReceiveDBQueryRequest receiveDBQueryRequest = new ReceiveDBQueryRequest();
		
		//== Database
		Database database = new Database(sendDBQueryResponse, receiveDBQueryRequest);
		
		//== Ports Security Manager
		SendAuthResponse sendAuthResponse = new SendAuthResponse();
		ReceiveAuthRequest receiveAuthRequest = new ReceiveAuthRequest();
		
		//== Security Manager
		SecurityManager securityManager = new SecurityManager(sendAuthResponse, receiveAuthRequest);
		
		//== Roles SQL Request
		ReceiveDBQueryResponseCalled receiveDBQueryResponseCalled = new ReceiveDBQueryResponseCalled();
		ReceiveDBQueryRequestCalled receiveDBQueryRequestCalled = new ReceiveDBQueryRequestCalled();
		SendDBQueryRequestCaller sendDBQueryRequestCaller = new SendDBQueryRequestCaller();
		SendDBQueryResponseCaller sendDBQueryResponseCaller = new SendDBQueryResponseCaller();
		
		//== SQL Request
		SQLRequest sqlRequest = new SQLRequest(receiveDBQueryResponseCalled,
				receiveDBQueryRequestCalled,
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
				sendSecurityCheckRequestCaller,
				sendAuthResponseCaller);
		
		//== Configuration Client Server
		ServerDetails serverDetails = new ServerDetails(connectionManager,
				database,
				securityManager,
				sqlRequest,
				clearanceRequest);
		
		//== Bigu configurationuuuuu
		ClientServer cs = new ClientServer(client, serveur, rpc, serverDetails);
		
		cs.getPortRequis("SendRequest").call("Hello world!");
	}

}
