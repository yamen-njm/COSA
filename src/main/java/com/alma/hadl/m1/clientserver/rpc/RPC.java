package com.alma.hadl.m1.clientserver.rpc;

import com.alma.hadl.m2.connecteur.Connecteur;
import com.alma.hadl.m2.connecteur.RoleFournis;
import com.alma.hadl.m2.connecteur.RoleRequis;

public class RPC extends Connecteur {
	
	public RPC(RoleRequis receiveRequestCalled,
			RoleRequis receiveResponseCalled,
			RoleFournis sendRequestCaller,
			RoleFournis sendResponseCaller) {
		this.ajouterRoles("ReceiveRequestCalled", receiveRequestCalled,
				"SendRequestCaller", sendRequestCaller);
		this.ajouterRoles("ReceiveResponseCalled", receiveResponseCalled,
				"SendResponseCaller", sendResponseCaller);
	}

}
