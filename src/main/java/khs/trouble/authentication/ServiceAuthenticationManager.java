/*
 * Copyright 2015 Keyhole Software LLC.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package khs.trouble.authentication;

import java.util.Collection;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;


public class ServiceAuthenticationManager implements AuthenticationManager {



	//private Authenticator authenticator;
	
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		final String serviceid = (String) authentication.getPrincipal();
		final String password = (String) authentication.getCredentials();
		String[] rolesArray = null;
		if (rolesArray != null) {
			
			SecurityContextImpl context = new SecurityContextImpl();
			
			 authentication = new Authentication() {
			    String id = serviceid;
			    String pw = password;
				public String getName() {
					return id;
				}
				
				public void setAuthenticated(boolean isAuthenticated)
						throws IllegalArgumentException {
					
				}
				
				public boolean isAuthenticated() {							
					return true;
				}
				
				public Object getPrincipal() {
					return null;
				}
				
				public Object getDetails() {
					return null;
				}
				
				public Object getCredentials() {
					return pw;
				}
				
				public Collection<? extends GrantedAuthority> getAuthorities() {
					return null;
				}

		
				public boolean implies(Subject subject) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			context.setAuthentication(authentication);
			SecurityContextHolder.setContext(context);
			
		}	
			
	
		return authentication;
	}



	
}