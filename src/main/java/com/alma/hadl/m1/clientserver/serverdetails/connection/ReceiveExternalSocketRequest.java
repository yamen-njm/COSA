package com.alma.hadl.m1.clientserver.serverdetails.connection;

import com.alma.hadl.m2.composant.PortComposantFournis;

public class ReceiveExternalSocketRequest extends PortComposantFournis {

	@Override
	protected void execute(String message) {
		try {
			this.getComposant().getPortRequis("SendSecurityCheckRequest").call("ADMIN:ADMIN");
			this.getComposant().getPortRequis("SendDBQueryRequest").call("SELECT * FROM Potatoes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
