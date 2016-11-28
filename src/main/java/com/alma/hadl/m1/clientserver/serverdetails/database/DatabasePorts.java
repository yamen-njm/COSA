package com.alma.hadl.m1.clientserver.serverdetails.database;

import java.util.ArrayList;
import java.util.List;

import com.alma.hadl.m2.composant.PortComposantFournis;

public class DatabasePorts {
	
	private boolean databaseInUse = false;
	private List<String> users = new ArrayList<String>();
	
	private ReceiveCQueryRequest receiveCQueryRequest = new ReceiveCQueryRequest();
	private ReceiveDBQueryRequest receiveDBQueryRequest = new ReceiveDBQueryRequest();

	public DatabasePorts() {
		users.add("Admin");
		users.add("User");
	}
	
	public PortComposantFournis getReceiveCQueryRequest() {
		return receiveCQueryRequest;
	}
	
	public PortComposantFournis getReceiveDBQueryRequest() {
		return receiveDBQueryRequest;
	}

	private class ReceiveCQueryRequest extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			this.getComposant().getPortRequis("SendCQueryResponse").call(databaseInUse ? "TRUE" : "FALSE");
		}

	}
	
	private class ReceiveDBQueryRequest extends PortComposantFournis {

		@Override
		protected void execute(String message) {
			databaseInUse = true;
			this.getComposant().getPortRequis("SendDBQueryResponse").call(users.toString());
			databaseInUse = false;
		}

	}

}
