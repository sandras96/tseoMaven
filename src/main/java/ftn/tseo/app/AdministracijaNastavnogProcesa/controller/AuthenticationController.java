package ftn.tseo.app.AdministracijaNastavnogProcesa.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.User;
import ftn.tseo.app.AdministracijaNastavnogProcesa.entity.UserTokenState;
import ftn.tseo.app.AdministracijaNastavnogProcesa.security.JwtAuthenticationRequest;
import ftn.tseo.app.AdministracijaNastavnogProcesa.security.TokenHelper;
import ftn.tseo.app.AdministracijaNastavnogProcesa.service.CustomUserDetailsService;







@RestController
@RequestMapping(value = "api/auth")
@CrossOrigin("*")
public class AuthenticationController {

	 	@Autowired
	    TokenHelper tokenHelper;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private CustomUserDetailsService userDetailsService;
	    

	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ResponseEntity<?> createAuthenticationToken(
	            @RequestBody JwtAuthenticationRequest authenticationRequest,
	            HttpServletResponse response
	    ) throws AuthenticationException, IOException {
	    	System.out.println(authenticationRequest.getUsername()+" " + authenticationRequest.getPassword());
	        // Izvrsavanje security dela
	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        authenticationRequest.getUsername(),
	                        authenticationRequest.getPassword()
	                )
	        );
	        

	        // Ubaci username + password u kontext
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        // Kreiraj token
	        User user = (User)authentication.getPrincipal();
	        if(user.isDeleted()) {
	        	return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	        }
	        String jws = tokenHelper.generateToken( user.getUsername());
	        String autority= null;
	        for (GrantedAuthority s : user.getAuthorities() ) {
	            
	            autority = s.getAuthority();
	            
	        }
	        // Vrati token kao odgovor na uspesno autentifikaciju
	        return ResponseEntity.ok(new UserTokenState(jws,user.getId(),autority));
	    }
	    
	    
	    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
	    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
	    	System.out.println("USer sa siframa: "+passwordChanger.oldPassword +passwordChanger.newPassword  );
	        userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
	        return new ResponseEntity<String>("Done",HttpStatus.OK);
	    }

	    static class PasswordChanger {
	        public String oldPassword;
	        public String newPassword;
	    }
	    
}
