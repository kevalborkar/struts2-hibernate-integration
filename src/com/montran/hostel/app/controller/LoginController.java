package com.montran.hostel.app.controller;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.montran.hostel.app.model.LoginModel;
import com.montran.hostel.app.serviceImpl.LoginActionImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class LoginController implements Action, ModelDriven<LoginModel>, ServletContextAware {

	private LoginModel loginUIModel = new LoginModel();

	private ServletContext context;

	@Override
	public void setServletContext(ServletContext scontext) {
		this.context = scontext;
	}

	@Override
	public LoginModel getModel() {
		return loginUIModel;
	}

	@Override
	public String execute() throws Exception {
		SessionFactory factory = (SessionFactory) context.getAttribute("SessionFactory");
		LoginActionImpl loginService = new LoginActionImpl(factory);
		LoginModel userPresent = loginService.getLoginModel(loginUIModel.getUserName(), loginUIModel.getPass());
		if (userPresent == null)
			return ERROR;
		else {
			loginUIModel.setUserName(userPresent.getUserName());
			loginUIModel.setPass(userPresent.getPass());
			return SUCCESS;
		}
	}

}
