package com.montran.hostel.app.serviceImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.montran.hostel.app.model.GuestModel;
import com.montran.hostel.app.service.IGuestAction;

public class GuestActionImpl implements IGuestAction {

	SessionFactory factory;

	@Override
	public boolean save(GuestModel guestModel) {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(guestModel);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println("Save in GuestActionImpl");
			return false;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuestModel> getAllGuestList() {
		Session session = factory.openSession();
		Query query = null;
		List<GuestModel> guestModelList = null;
		try {
			String hql = "From GuestModel";
			query = session.createQuery(hql);
			guestModelList =  query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("In getAllGuestList()-->GuestActionImpl ");
		}

		return guestModelList;

	}

}
