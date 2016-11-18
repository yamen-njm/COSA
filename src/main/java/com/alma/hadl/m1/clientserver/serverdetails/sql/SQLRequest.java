package com.alma.hadl.m1.clientserver.serverdetails.sql;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;

public class SQLRequest extends Connecteur {

	public SQLRequest(RoleRequis receiveDBQueryResponseCalled,
			RoleRequis receiveDBQueryRequestCalled,
			RoleFournis sendDBQueryRequestCaller,
			RoleFournis sendDBQueryResponseCaller) {
		this.ajouterRoles("ReceiveDBQueryResponseCalled", receiveDBQueryResponseCalled,
				"SendDBQueryRequestCaller", sendDBQueryRequestCaller);
		this.ajouterRoles("ReceiveDBQueryRequestCalled", receiveDBQueryRequestCalled,
				"SendDBQueryResponseCaller", sendDBQueryResponseCaller);
	}
	
}
