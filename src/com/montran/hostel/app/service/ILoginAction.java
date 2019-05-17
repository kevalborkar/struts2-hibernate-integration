package com.montran.hostel.app.service;

import com.montran.hostel.app.model.LoginModel;

public interface ILoginAction {
	
	public LoginModel getLoginModel(String username, String password);
	
}
