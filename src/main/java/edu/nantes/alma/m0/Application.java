package edu.nantes.alma.m0;

import edu.nantes.alma.m1.client.Client;
import edu.nantes.alma.m1.clientserver.ClientServer;
import edu.nantes.alma.m1.server.Server;



public class Application {

	public static void main(String[] args) {
		//== Client
		Client client = new Client();
		//== Configuration Client Server
		Server serverDetails = new Server();
		//== client server configuration
		ClientServer cs = new ClientServer(client, serverDetails);
		
		cs.getPortRequis("SendRequest").call("Hello");
	}

}
