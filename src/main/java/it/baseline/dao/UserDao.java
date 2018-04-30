package it.baseline.dao;

import it.baseline.model.User;

public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
}

