package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class GuestBookMgr {
	
	private DBConnectionMgr pool;
	private final SimpleDateFormat SDF_DATE =
			new SimpleDateFormat("yyyy'년'  M'월' d'일' (E)");
	private final SimpleDateFormat SDF_TIME =
			new SimpleDateFormat("H:mm:ss");
	
	public GuestBookMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Join Login   //db1 사용
	public boolean loginJoin(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tblJoin where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();  //결과값이 있으면 true, 없으면 false
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	//Join Information  //로그인 정보 //db1 사용
	public JoinBean getJoin(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		JoinBean bean = new JoinBean();
		try {
			con = pool.getConnection();
			sql = "select * from tbljoin where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setId(rs.getString(1));
				bean.setPwd(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setHp(rs.getString(5));
				bean.setGrade(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		 return bean;
	}

//GuestBook List
	public Vector<GuestBookBean> listGuestBook(String id, String grade){
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = null;
	    Vector<GuestBookBean> vlist = new Vector<GuestBookBean>();
	    try {
	        con = pool.getConnection();
	        if(grade.equals("1")) {
	            sql ="select * from tblGuestBook order by num desc";
	            pstmt = con.prepareStatement(sql);
	        } else if(grade.equals("0")) {
	            sql ="select * from tblGuestBook where id = ? or secret = '0' order by num desc";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id);
	        }
	        rs = pstmt.executeQuery();
	        while(rs.next()) {
	            GuestBookBean bean = new GuestBookBean();
	            bean.setNum(rs.getInt("num"));
	            bean.setId(rs.getString("id"));
	            bean.setContents(rs.getString("contents"));
	            bean.setIp(rs.getString("ip"));
	            String tempDate = SDF_DATE.format(rs.getDate("regDate"));
	            bean.setRegdate(tempDate);
	            String tempTime = SDF_DATE.format(rs.getTime("regTime"));
	            bean.setRegtime(tempTime);
	            bean.setSecret(rs.getString("secret"));
	            vlist.addElement(bean);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        pool.freeConnection(con, pstmt, rs);
	    }
	    return vlist;
	}
//GuestBook Read
//select * from tblGuestBook where num = ?
public GuestBookBean getGuestBook(int num) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	GuestBookBean bean = new GuestBookBean();
	try {
		con = pool.getConnection();
		sql = "select * from tblGuestBook where num = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			bean.setNum(rs.getInt("num"));
			bean.setId(rs.getString("id"));
			bean.setContents(rs.getString("contents"));
			bean.setIp(rs.getString("ip"));
			String tempDate = SDF_DATE.format(rs.getDate("regDate"));
			bean.setRegdate(tempDate);
			String tempTime = SDF_DATE.format(rs.getTime("regTime"));
			bean.setRegtime(tempTime);
			bean.setSecret(rs.getString("secret"));
		}
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	return bean;
	  	
}
//GuestBook Insert
//sql = 
public void insertGuestBook(GuestBookBean bean) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "insert tblguestbook values(null,?,?,?,now(),now(),?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bean.getId());
		pstmt.setString(2, bean.getContents());
		pstmt.setString(3, bean.getIp());
		pstmt.setString(4, bean.getSecret());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	return;
}

//GuestBook Update :content, ip, secret
public void updateGuestbook(GuestBookBean bean) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "update tblguestbook set contents=?,ip=?,secret=? where num =? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,bean.getContents());
		pstmt.setString(2,bean.getIp());
		pstmt.setString(3,bean.getSecret());
		pstmt.setInt(4,bean.getNum());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	return;
}

//GuestBook Delete
public void deleteGuestbook(int num) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "delete from tblGuestBook where num=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	return;
}
}