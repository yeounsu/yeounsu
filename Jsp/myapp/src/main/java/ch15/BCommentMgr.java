package ch15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class BCommentMgr {

	private DBConnectionMgr pool;
	
	public BCommentMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Comment Insert(read.jsp)
	public void insertBComment(BCommentBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert tblbComment(name,comment,regdate,num) values(?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getComment());
			pstmt.setInt(3, bean.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return;
	}
	
	
	//Comment List(read.jsp)
	public Vector<BCommentBean>getBCommentList(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<BCommentBean> vlist = new Vector<BCommentBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblbcomment where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt .setInt(1,  num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BCommentBean bean = new BCommentBean();
				bean.setCnum(rs.getInt(1));
				bean.setNum(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setComment(rs.getString(4));
				bean.setRegdate(rs.getString(5));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	
	//Comment Count(list.jsp)
	public int getBCommentCount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int cnt = 0;
		try {
			con = pool.getConnection();
			sql = "select count(num) from tblBComment where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cnt);
			rs = pstmt.executeQuery();
			if(rs.next())cnt = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return cnt;
	}
	
	
	//Comment Delete(read.jsp)
	public void deleteBComment(int cnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "delete from tblbcomment where cnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	
	//Comment All Delete(BoardDeleteServlet)
	public void deleteAllBComment(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "delete from tblbcomment where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}

	
}
