package com.montran.hostel.app.serviceImpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.montran.hostel.app.model.LoginModel;
import com.montran.hostel.app.service.ILoginAction;

public class LoginActionImpl implements ILoginAction {

	private SessionFactory factory;

	public LoginActionImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public LoginModel getLoginModel(String userName, String password) {
		Session session = factory.openSession();
		Query query = null;
		LoginModel loginModel = null;
		try {
			String hql = "From userTable UT where UT.userName=:userName and UT.password=:password ";
			query = session.createQuery(hql);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			loginModel = (LoginModel) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("In getGuestModel()-->LoginActionImpl ");
		}
		return loginModel;
	}

}
