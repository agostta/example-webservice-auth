package com.example.webservice.auth;
import java.util.Set;

import javax.ejb.EJB;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AuthHandler implements SOAPHandler<SOAPMessageContext> {

	@EJB
	private AuthBean auth;
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		if (!this.isOutbounded(context)) {
			
			String username = (String) context.get(BindingProvider.USERNAME_PROPERTY);
			String password = (String) context.get(BindingProvider.PASSWORD_PROPERTY);
			
			auth.validate(username, password);
				
			return true;
		}
		
		return true;
	}

	private boolean isOutbounded(SOAPMessageContext context) {
		return (boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
