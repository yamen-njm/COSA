package edu.nantes.alma.m1.server.connection;

import java.util.LinkedList;
import java.util.Queue;

import edu.nantes.alma.m2.composant.PortComposantFournis;

public class ConnectionPorts {
	
	private Queue<String> requests = new LinkedList<String>();
	
	private PortComposantFournis receiveExternalSocketRequest = new ReceiveExternalSocketRequest();
	private PortComposantFournis receiveSecurityCheckResponse = new ReceiveSecurityCheckResponse();
	private PortComposantFournis receiveDBQueryResponse = new ReceiveDBQueryResponse();
	
	public PortComposantFournis getReceiveExternalSocketRequest() {
		return receiveExternalSocketRequest;
	}

	public PortComposantFournis getReceiveSecurityCheckResponse() {
		return receiveSecurityCheckResponse;
	}
	
	public PortComposantFournis getReceiveDBQueryResponse() {
		return receiveDBQueryResponse;
	}
	
	private class ReceiveExternalSocketRequest extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			requests.add(message);
			this.getComposant().getPortRequis("SendSecurityCheckRequest").call("ADMIN:ADMIN");
		}

	}
	
	private class ReceiveSecurityCheckResponse extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			if (message.equals("OK")) {
				this.getComposant().getPortRequis("SendDBQueryRequest").call("SELECT * FROM Users");
			}
		}

	}
	
	private class ReceiveDBQueryResponse extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			this.getComposant().getPortRequis("SendExternalSocketResponse").call(requests.poll() + " " + message + "!");
		}

	}

}
