package com.alma.hadl.m1.clientserver.serverdetails.connection;

import com.alma.hadl.m2.composant.PortComposantFournis;

public class ReceiveExternalSocketRequest extends PortComposantFournis {

	@Override
	protected void execute(String message) {
		this.getComposant().getPortRequis("SendSecurityCheckRequest").call("ADMIN:ADMIN");
		this.getComposant().getPortRequis("SendDBQueryRequest").call("SELECT * FROM Potatoes");
	}

}
