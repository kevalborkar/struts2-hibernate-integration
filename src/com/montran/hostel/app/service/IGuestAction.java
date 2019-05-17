package com.montran.hostel.app.service;

import java.util.List;

import com.montran.hostel.app.model.GuestModel;

public interface IGuestAction {
	
	public boolean save(GuestModel guestModel);
	
	public List<GuestModel> getAllGuestList();
	

}
