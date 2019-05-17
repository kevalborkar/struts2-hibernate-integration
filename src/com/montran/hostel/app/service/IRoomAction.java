package com.montran.hostel.app.service;

import java.util.List;

import com.montran.hostel.app.model.RoomModel;

public interface IRoomAction {
	
	public boolean save(RoomModel roomModel);
	
	public List<RoomModel> getRoomData();
	
	public RoomModel getRoomDataByRoomNumber(Integer roomNumber);
	
	
		
		
	

}
