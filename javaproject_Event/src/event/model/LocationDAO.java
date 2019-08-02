package event.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import event.model.dto.LocationDTO;
import event.model.util.DBUtil;

public class LocationDAO {
	public static boolean addLocation(LocationDTO location) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into location values(?, ?)");
			pstmt.setInt(1, location.getAreaCode());
			pstmt.setString(2, location.getLocation());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// areaCode로 location 내용 수정하기
	public static boolean updateLocation(int areaCode, String location) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update location set areaCode=? where location=?");
			pstmt.setInt(1, areaCode);
			pstmt.setString(2, location);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// areaCode로 location 삭제
	public static boolean deleteLocation(int areaCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from location where areaCode=?");
			pstmt.setInt(1, areaCode);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// areaCode로 지역의 모든 정보 반환
	public static LocationDTO getLocation(int areaCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		LocationDTO location = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from location where areaCode=?");
			pstmt.setInt(1, areaCode);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				location = new LocationDTO(rset.getInt(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return location;
	}

	// 모든 location 반환
	public static ArrayList<LocationDTO> getAllLocations() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<LocationDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from location");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<LocationDTO>();
			while(rset.next()){
				list.add(new LocationDTO(rset.getInt(1), rset.getString(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
