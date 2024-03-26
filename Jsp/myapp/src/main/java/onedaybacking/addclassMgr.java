package onedaybacking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import guestbook.DBConnectionMgr;
import guestbook.GuestBookBean;

public class addclassMgr {
	private DBConnectionMgr pool;
	
	public addclassMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	public void insertClass(addclassBean classBean) {
        Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			 sql = "INSERT INTO classes (member_id, classname, classdate, classmin, classmax, classprice, classtime, addressdetail, categorykey, offercontent, classtatus, classteacherinfo, classteacherimg, classimg1, classimg2, classimg3, classimg4, classimg5, classcontent, roomimg1, roomimg2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, classBean.getMemberId());
	            pstmt.setString(2, classBean.getClassname());
	            pstmt.setString(3, classBean.getClassdate());
	            pstmt.setInt(4, classBean.getClassmin());
	            pstmt.setInt(5, classBean.getClassmax());
	            pstmt.setInt(6, classBean.getClassprice());
	            pstmt.setInt(7, classBean.getClasstime());
	            pstmt.setString(8, classBean.getAddressdetail());
	            pstmt.setInt(9, classBean.getCategorykey());
	            pstmt.setString(10, classBean.getOffercontent());
	            pstmt.setString(11, classBean.getClassstatus());
	            pstmt.setString(12, classBean.getClassteacherinfo());
	            pstmt.setString(13, classBean.getClassteacherimg());
	            pstmt.setString(14, classBean.getClassimg1());
	            pstmt.setString(15, classBean.getClassimg2());
	            pstmt.setString(16, classBean.getClassimg3());
	            pstmt.setString(17, classBean.getClassimg4());
	            pstmt.setString(18, classBean.getClassimg5());
	            pstmt.setString(19, classBean.getClasscontent());
	            pstmt.setString(20, classBean.getRoomimg1());
	            pstmt.setString(21, classBean.getRoomimg2());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				addclassBean bean = new addclassBean();
				bean.setMemberId(rs.getString(1));
				bean.setClassname(rs.getString(2));
				bean.setClassdate(rs.getString(3));
				bean.setClassmin(rs.getInt(4));
				bean.setClassmax(rs.getInt(5));
				bean.setClassprice(rs.getInt(6));
				bean.setClasstime(rs.getInt(7));
				bean.setAddressdetail(rs.getString(8));
				bean.setCategorykey(rs.getInt(9));
				bean.setOffercontent(rs.getString(10));
				bean.setClassstatus(rs.getString(11));
				bean.setClassteacherinfo(rs.getString(12));
				bean.setClassteacherimg(rs.getString(13));
				bean.setClassimg1(rs.getString(14));
				bean.setClassimg2(rs.getString(15));
				bean.setClassimg3(rs.getString(16));
				bean.setClassimg4(rs.getString(17));
				bean.setClassimg5(rs.getString(18));
				bean.setClasscontent(rs.getString(19));
				bean.setRoomimg1(rs.getString(20));
				bean.setRoomimg2(rs.getString(21));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
 
}
}
	
    


