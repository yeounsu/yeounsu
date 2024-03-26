package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class CommentMgr {
	
	private DBConnectionMgr pool;
	private final SimpleDateFormat SDF_DATE =
			new SimpleDateFormat("yyyy'년'  M'월' d'일' (E)");
	public CommentMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Comment Insert
	public void insertComment(CommentBean bean) {
		   Connection con = null;
	        PreparedStatement pstmt = null;
	        String sql = null;
	        
	        try {
	            con = pool.getConnection();
	           sql = "INSERT INTO tblcomment VALUES (null,?, ?, ?, ?, now())";
	            pstmt = con.prepareStatement(sql);
	            
	            pstmt.setInt(1, bean.getNum());
	            pstmt.setString(2, bean.getCid());
	            pstmt.setString(3, bean.getComment());
	            pstmt.setString(4, bean.getCip());
	            pstmt.executeUpdate();
	        } catch (Exception e) {
	    		e.printStackTrace();
	    	} finally {
	    		pool.freeConnection(con, pstmt);
	    	}
	    	return;
	    }
	//Comment List
	public Vector<CommentBean> listComment(int num){
		 Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Vector<CommentBean> commentList = new Vector<>();
	        
	        try {
	            con = pool.getConnection();
	            String sql = "SELECT * FROM tblcomment WHERE num=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, num);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	                CommentBean bean = new CommentBean();
	                bean.setCnum(rs.getInt("cnum"));
	                bean.setNum(rs.getInt("num"));
	                bean.setCid(rs.getString("cid"));
	                bean.setComment(rs.getString("comment"));
	                bean.setCip(rs.getString("cip"));
	                String cregDate = SDF_DATE.format(rs.getDate("cregDate"));
	                bean.setCregDate(cregDate);
	                commentList.addElement(bean);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            pool.freeConnection(con, pstmt, rs);
	        }
	        return commentList;
	    }
	//Comment Delete
	public void deleteComment(int cnum) {
		   Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            con = pool.getConnection();
	            String sql = "DELETE FROM tblcomment WHERE cnum=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, cnum);
	            pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            pool.freeConnection(con, pstmt);
	        }
	    }
	//Comment All Delete:원글 삭제시 관련된 댓글 모두 삭제
	public void deleteAllComment(int num) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = pool.getConnection();
            String sql = "DELETE FROM tblcomment WHERE num=?";
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
