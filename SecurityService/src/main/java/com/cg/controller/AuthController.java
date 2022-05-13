package com.cg.controller;

import org.springframework.web.bind.annotation.RestController;


import com.cg.model.AuthenticationRequest;
import com.cg.model.AuthenticationResponse;
import com.cg.model.UserModel;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;
import com.cg.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class AuthController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@GetMapping("/dashboard")
	private String testingToken() {
		return "Welcome to DashBoard"; //+ ((AbstractAuthenticationToken) SecurityContextHolder.getContext()).getName();
		
	}


	
	@PostMapping("/register")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		UserModel userModel = new UserModel();
		userModel.setUsername(username);
		userModel.setPassword(password);
		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse(" Error during Customer Registration "   +  username));

		}
		
		return ResponseEntity.ok(new AuthenticationResponse(" Succesful Registration for Customer "   +  username));

	}

	
	
	
	
	@PostMapping("/login")
      private ResponseEntity<?> authentictionClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error during Customer Login "  +  username));
		}

		UserDetails loadedUser = userService.loadUserByUsername(username);
		
		String generatedToken = jwtUtils.generateToken(loadedUser);
		
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));

		

		
	}

	

}
