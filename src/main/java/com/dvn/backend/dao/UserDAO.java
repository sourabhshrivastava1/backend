package com.dvn.backend.dao;

import java.util.List;

import com.dvn.backend.model.User;

public interface UserDAO {
	
	
	
public List<User> list();
	
//User login(User user);
	public User get(String id, String password);

	public User get(String id);

	// public void saveOrUpdate(UserDetails UserDetails);

	public boolean save(User user);

	public boolean update(User user);

	public boolean delete(String id);

	public User authenticate(String id, String name);

	

	public User isValidCredentials(String id, String pwd);
	public boolean saveOrupdate(User user);
	

	public User validate(String id, String password);

}
