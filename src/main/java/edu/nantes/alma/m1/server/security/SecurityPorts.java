package edu.nantes.alma.m1.server.security;

import edu.nantes.alma.m2.composant.PortComposantFournis;

public class SecurityPorts {
	
	private ReceiveAuthRequest receiveAuthRequest = new ReceiveAuthRequest();
	private ReceiveCQueryResponse receiveCQueryResponse = new ReceiveCQueryResponse();
	
	public ReceiveAuthRequest getReceiveAuthRequest() {
		return receiveAuthRequest;
	}

	public ReceiveCQueryResponse getReceiveCQueryResponse() {
		return receiveCQueryResponse;
	}
	
	private class ReceiveAuthRequest extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			if (message.equals("ADMIN:ADMIN")) {
				this.getComposant().getPortRequis("SendCQueryRequest").call("is database in used?");
			} else {
				this.getComposant().getPortRequis("SendAuthResponse").call("KO");
			}
		}

	}
	
	private class ReceiveCQueryResponse extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			if (message == "FALSE") {
				this.getComposant().getPortRequis("SendAuthResponse").call("OK");
			} else {
				this.getComposant().getPortRequis("SendAuthResponse").call("KO");
			}
		}

	}

}
