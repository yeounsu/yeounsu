package onedaybaking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class WishMgr {
	DBConnectionMgr pool;
	
	public WishMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//클래스 신청 갯수 (개인)
	public int getapplicationclass(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		try {
			con = pool.getConnection();
			sql = "select count(*) from class where memberid = ? and classdelete = 'N'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return count;
	}

	
	//클래스 신청 리스트
	public Vector<ClassBean> getWishItemList(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ClassBean> vlist = new Vector<ClassBean>();
		try {
			con = pool.getConnection();
			sql = "select * from class a "
					+ "left outer join class b on a.classkey = b.classkey "
					+ "left outer join member c on b.memberid = c.memberid "
					+ "where a.memberId = ? and a.classdelete = 'N'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClassBean bean = new ClassBean();
				bean.setClasskey(rs.getInt("classKey"));
				bean.setOffercontent(rs.getString("offercontent"));
				bean.setClassname(rs.getString("classname"));
				bean.setClassprice(rs.getInt("classprice"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}


}