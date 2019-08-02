package event.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import event.model.dto.EventDTO;
import event.model.util.DBUtil;

public class EventDAO {
	
	public static boolean addEvent(JSONArray event) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			for(int i=0; i<event.size(); i++) {
				JSONObject eventitem = ((JSONObject)event.get(i));
				pstmt = con.prepareStatement("insert into event values(eventNo.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, eventitem.get("title").toString());
				pstmt.setString(2, eventitem.get("addr1").toString());
				pstmt.setString(3, eventitem.get("eventstartdate").toString());
				pstmt.setString(4, eventitem.get("eventenddate").toString());
				if(eventitem.get("tel") != null) {
					pstmt.setString(5, eventitem.get("tel").toString());
				}else {
					pstmt.setString(5, "0");
				}
				pstmt.setString(6, eventitem.get("readcount").toString());
				pstmt.setString(7, eventitem.get("cat3").toString());
				pstmt.setString(8, eventitem.get("areacode").toString());
				int result = pstmt.executeUpdate();
				if(result != 1){
					return true;
				}
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean insertEvent(EventDTO newEvent) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement("insert into event values(eventNo.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");
	         
	         pstmt.setString(1, newEvent.getTitle());
	         pstmt.setString(2, newEvent.getAddress());
	         pstmt.setString(3, newEvent.getEventStartDate());
	         pstmt.setString(4, newEvent.getEventEndDate());
	         pstmt.setString(5, newEvent.getTel());
	         pstmt.setString(6, newEvent.getReadCount());
	         pstmt.setString(7, newEvent.getCatNumber());
	         pstmt.setString(8, newEvent.getAreaCode());
	         
	         int r = pstmt.executeUpdate(); //auto commit
	         if(r != 0) {
	        	 return true;
	         }
	      }finally {
	         DBUtil.close(con, pstmt);
	      }
	      
	      return false;
	   }
	
	// title로 event tel 수정하기
	public static boolean updateEvent(String tel, String title) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update event set tel=? where title=?");
			pstmt.setString(1, tel);
			pstmt.setString(2, title);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// title로  event삭제
	public static boolean deleteEvent(String title) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from event where title=?");
			pstmt.setString(1, title);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// title로 모든 해당 event 출력
	public static EventDTO getEvent(String title) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EventDTO event = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from event where title = ?");
			pstmt.setString(1, title);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				event = new EventDTO(rset.getString("title"), rset.getString("eventstartdate"), rset.getString("eventenddate"), rset.getString("address"), rset.getString("tel"), rset.getString("readcount"), rset.getString("catnumber"), rset.getString("areacode"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return event;
	}

	//Location으로 Event 출력
	public static ArrayList<EventDTO> getLocationEvent(String location) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EventDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select e.title, e.eventstartdate, e.eventenddate, e.address, e.tel, e.readcount, e.catnumber, e.areacode from event e, location l where e.areaCode = l.areaCode and l.location = ?");
			pstmt.setString(1, location);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<EventDTO>();
			while (rset.next()) {
				list.add(new EventDTO(rset.getString("title"), rset.getString("eventstartdate"), rset.getString("eventenddate"), rset.getString("address"), rset.getString("tel"), rset.getString("readcount"), rset.getString("catnumber"), rset.getString("areacode")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	//category으로 Event 출력
	public static ArrayList<EventDTO> getCategoryEvent(String category) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EventDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select e.title, e.eventstartdate, e.eventenddate, e.address, e.tel, e.readcount, e.catnumber, e.areacode from event e, category c where e.catNumber = c.catNumber and c.category = ?");
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<EventDTO>();
			while (rset.next()) {
				list.add(new EventDTO(rset.getString("title"), rset.getString("eventstartdate"), rset.getString("eventenddate"), rset.getString("address"), rset.getString("tel"), rset.getString("readcount"), rset.getString("catnumber"), rset.getString("areacode")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// 모든 event 검색해서 반환
	public static ArrayList<EventDTO> getAllEvents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EventDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select title, eventstartdate, eventenddate, address, tel, readcount, catnumber, areacode from event order by eventstartdate");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<EventDTO>();
			while(rset.next()){
				list.add(new EventDTO(rset.getString("title"), rset.getString("eventstartdate"), rset.getString("eventenddate"), rset.getString("address"), rset.getString("tel"), rset.getString("readcount"), rset.getString("catnumber"), rset.getString("areacode")));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
