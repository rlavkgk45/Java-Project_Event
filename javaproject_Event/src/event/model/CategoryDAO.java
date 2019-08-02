package event.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import event.model.dto.CategoryDTO;
import event.model.util.DBUtil;

public class CategoryDAO {
	public static boolean addActivist(CategoryDTO category) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into activist values(?, ?)");
			pstmt.setString(1, category.getCatNumber());
			pstmt.setString(2, category.getCategory());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// 카테고리 catnumber로 category 내용 수정하기
	public static boolean updateCategory(String catNumber, String category) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update category set catNumber=? where category=?");
			pstmt.setString(1, catNumber);
			pstmt.setString(2, category);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// catNumber로 category 삭제
	public static boolean deleteCategory(String catNumber) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from category where catNumber=?");
			pstmt.setString(1, catNumber);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// catNumber로 카테고리 정보 반환
	public static CategoryDTO getCategory(String catNumber) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CategoryDTO category = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category where catNumber=?");
			pstmt.setString(1, catNumber);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				category = new CategoryDTO(rset.getString(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return category;
	}

	//카테고리로 정보반환
	public static CategoryDTO getCategoryname(String category) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CategoryDTO categoryname = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category where category=?");
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				categoryname = new CategoryDTO(rset.getString(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return categoryname;
	}
	
	// 모든 category 검색해서 반환
	public static ArrayList<CategoryDTO> getAllCategorys() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CategoryDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CategoryDTO>();
			while(rset.next()){
				list.add(new CategoryDTO(rset.getString(1), rset.getString(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
