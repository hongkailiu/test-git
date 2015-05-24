package tk.hongkailiu.test.webapp.cxf.service;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class ClientPasswordCallback implements CallbackHandler {

	private String username;
	private String password;
	
	public ClientPasswordCallback(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];  
        pc.setIdentifier(username);  
        pc.setPassword(password);  
	}

}
