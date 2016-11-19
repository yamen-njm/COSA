package com.alma.hadl.m1.clientserver;

import com.alma.hadl.m1.clientserver.client.Client;
import com.alma.hadl.m1.clientserver.rpc.RPC;
import com.alma.hadl.m1.clientserver.server.Server;
import com.alma.hadl.m1.clientserver.serverdetails.ServerDetails;
import com.alma.hadl.m2.configuration.Configuration;
import com.alma.hadl.m2.configuration.PortConfigurationFournis;
import com.alma.hadl.m2.configuration.PortConfigurationRequis;

/**
 * Created by sidali on 17/10/2016.
 */
public class ClientServer extends Configuration {
			
	public ClientServer(Client client, Server server, RPC rpc, ServerDetails serverDetails) {
		//== Ports
		PortConfigurationRequis sendRequest = new SendRequest();
		PortConfigurationFournis receiveResponse = new ReceiveResponse();
		
		this.ajouterPortRequis("SendRequest", sendRequest);
		this.ajouterPortFournis("ReceiveResponse", receiveResponse);
		
		this.attacher(client.getPortRequis("SendRequest"), rpc.getRoleFournis("SendRequestCaller"));
		this.attacher(client.getPortFournis("ReceiveResponse"), rpc.getRoleRequis("ReceiveResponseCalled"));
		this.attacher(server.getPortRequis("SendResponse"), rpc.getRoleFournis("SendResponseCaller"));
		this.attacher(server.getPortFournis("ReceiveRequest"), rpc.getRoleRequis("ReceiveRequestCalled"));
		
		this.bind(sendRequest, client.getPortRequis("SendRequest"));
		this.bind(client.getPortFournis("ReceiveResponse"), receiveResponse);
		
		this.bind(serverDetails.getPortRequis("SendResponse"), server.getPortRequis("SendResponse"));
		this.bind(server.getPortFournis("ReceiveRequest"), serverDetails.getPortFournis("ReceiveRequest"));
	}
	
}
