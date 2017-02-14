package com.amaker.dao;

import java.util.List;

import com.amaker.bean.User;

public interface UserDao {
	
	public boolean register(User user);
	
	public boolean check(User user);
	
	public List search(String name, String password);
}
