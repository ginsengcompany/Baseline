package it.baseline.service;

import it.baseline.model.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}