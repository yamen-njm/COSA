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
import com.alma.hadl.m1.clientserver.serverdetails.connection.ConnectionManager;
import com.alma.hadl.m1.clientserver.serverdetails.connection.ReceiveDBQueryResponse;
import com.alma.hadl.m1.clientserver.serverdetails.connection.ReceiveExternalSocketRequest;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendDBQueryRequest;
import com.alma.hadl.m1.clientserver.serverdetails.connection.SendExternalSocketResponse;
import com.alma.hadl.m1.clientserver.serverdetails.database.Database;
import com.alma.hadl.m1.clientserver.serverdetails.database.ReceiveDBQueryRequest;
import com.alma.hadl.m1.clientserver.serverdetails.database.SendDBQueryResponse;
import com.alma.hadl.m1.clientserver.serverdetails.sql.ReceiveDBQueryRequestCalled;
import com.alma.hadl.m1.clientserver.serverdetails.sql.ReceiveDBQueryResponseCalled;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SQLRequest;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SendDBQueryRequestCaller;
import com.alma.hadl.m1.clientserver.serverdetails.sql.SendDBQueryResponseCaller;

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
		RPC rpc = new RPC(sendRequestCaller,
				receiveRequestCalled,
				sendResponseCaller,
				receiveResponseCalled);
		
		//== Ports Connection Manager
		ReceiveExternalSocketRequest receiveExternalSocketRequest = new ReceiveExternalSocketRequest();
		SendExternalSocketResponse sendExternalSocketResponse = new SendExternalSocketResponse();
		SendDBQueryRequest sendDBQueryRequest = new SendDBQueryRequest();
		ReceiveDBQueryResponse receiveDBQueryResponse = new ReceiveDBQueryResponse();
		
		//== Connection Manager
		ConnectionManager connectionManager = new ConnectionManager(receiveExternalSocketRequest,
				sendExternalSocketResponse,
				receiveDBQueryResponse,
				sendDBQueryRequest);
		
		//== Ports Database
		ReceiveDBQueryRequest receiveDBQueryRequest = new ReceiveDBQueryRequest();
		SendDBQueryResponse sendDBQueryResponse = new SendDBQueryResponse();
		
		//== Database
		Database database = new Database(sendDBQueryResponse, receiveDBQueryRequest);
		
		//== Roles SQL Request
		SendDBQueryRequestCaller sendDBQueryRequestCaller = new SendDBQueryRequestCaller();
		ReceiveDBQueryResponseCalled receiveDBQueryResponseCalled = new ReceiveDBQueryResponseCalled();
		SendDBQueryResponseCaller sendDBQueryResponseCaller = new SendDBQueryResponseCaller();
		ReceiveDBQueryRequestCalled receiveDBQueryRequestCalled = new ReceiveDBQueryRequestCalled();
		
		//== SQL Request
		SQLRequest sqlRequest = new SQLRequest(sendDBQueryRequestCaller,
				receiveDBQueryResponseCalled,
				sendDBQueryResponseCaller,
				receiveDBQueryRequestCalled);
		
		//== Configuration Client Server
		ServerDetails serverDetails = new ServerDetails(connectionManager, database, sqlRequest);
		
		//== Bigu configurationuuuuu
		ClientServer cs = new ClientServer(client, serveur, rpc, serverDetails);
		
		cs.getPortRequis("SendRequest").call("Hello world!");
	}

}
