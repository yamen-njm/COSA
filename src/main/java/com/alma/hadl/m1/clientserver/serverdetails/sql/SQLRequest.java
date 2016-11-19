package com.alma.hadl.m1.clientserver.serverdetails.sql;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;

public class SQLRequest extends Connecteur {

	public SQLRequest(RoleRequis receiveDBQueryRequestCalled,
			RoleRequis receiveDBQueryResponseCalled,
			RoleFournis sendDBQueryRequestCaller,
			RoleFournis sendDBQueryResponseCaller) {
		this.ajouterRoles("ReceiveDBQueryRequestCalled", receiveDBQueryRequestCalled,
				"SendDBQueryRequestCaller", sendDBQueryRequestCaller);
		this.ajouterRoles("ReceiveDBQueryResponseCalled", receiveDBQueryResponseCalled,
				"SendDBQueryResponseCaller", sendDBQueryResponseCaller);
	}
	
}
