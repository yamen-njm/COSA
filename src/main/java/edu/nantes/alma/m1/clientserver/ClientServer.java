package edu.nantes.alma.m1.clientserver;

import edu.nantes.alma.m1.client.Client;
import edu.nantes.alma.m1.rpc.RPC;
import edu.nantes.alma.m1.server.Server;
import edu.nantes.alma.m2.configuration.Configuration;
import edu.nantes.alma.m2.configuration.PortConfigurationFournis;
import edu.nantes.alma.m2.configuration.PortConfigurationRequis;


public class ClientServer extends Configuration {
			
	public ClientServer(Client client, Server serverDetails) {
		//== Ports
		//== RPC
			RPC rpc = new RPC();
		PortConfigurationRequis sendRequest = new SendRequest();
		PortConfigurationFournis receiveResponse = new ReceiveResponse();
		
		this.ajouterPortRequis("SendRequest", sendRequest);
		this.ajouterPortFournis("ReceiveResponse", receiveResponse);
		
		this.attach(client.getPortRequis("SendRequest"), rpc.getRoleFournis("SendRequestCaller"));
		this.attach(client.getPortFournis("ReceiveResponse"), rpc.getRoleRequis("ReceiveResponseCalled"));
		this.attach(serverDetails.getPortRequis("SendResponse"), rpc.getRoleFournis("SendResponseCaller"));
		this.attach(serverDetails.getPortFournis("ReceiveRequest"), rpc.getRoleRequis("ReceiveRequestCalled"));
		
		this.bind(sendRequest, client.getPortRequis("SendRequest"));
		this.bind(client.getPortFournis("ReceiveResponse"), receiveResponse);
		

	}
	
}
