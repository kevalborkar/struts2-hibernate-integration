package com.montran.hostel.app.serviceImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.montran.hostel.app.model.RoomModel;
import com.montran.hostel.app.service.IRoomAction;

public class RoomActionImpl implements IRoomAction {

	SessionFactory factory;

	@Override
	public boolean save(RoomModel roomModel) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(roomModel);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println("Save in RoomActionImpl");
			return false;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomModel> getRoomData() {

		Session session = factory.openSession();
		Query query = null;
		List<RoomModel> roomModelList = null;
		try {
			String hql = "From RoomModel";
			query = session.createQuery(hql);
			roomModelList = query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("In getRoomData()-->RoomActionImpl ");
		}
		return roomModelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RoomModel getRoomDataByRoomNumber(Integer roomNumber) {

		Session session = factory.openSession();
		Query query = null;
		RoomModel roomModel = new RoomModel();
		try {
			String hql = "From RoomModel RM where RM.rooNumber=:roomNumber";
			query = session.createQuery(hql);
			query.setParameter("roomNumber", roomNumber);
			List<RoomModel> roomModelData = query.list();
			if (roomModelData != null) {
				for (RoomModel data : roomModelData) {
					roomModel.setRoomNumber(data.getRoomNumber());
					roomModel.setBedType(data.getBedType());
					roomModel.setRate(data.getRate());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("In getRoomDataByRoomNumber()-->RoomActionImpl ");
		}
		return roomModel;
	}
}
