package onedaybaking;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class categoryMgr {
	private DBConnectionMgr pool;
	
	public categoryMgr() {
		pool= DBConnectionMgr.getInstance();
	}
	public boolean insertCategory(categoryBean cateBean) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    String sql = null;
	    boolean flag = false;
	    try {
	        con = pool.getConnection();
	        sql = "insert into onedaycategory (categorygroup, categoryname) values (?, ?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, cateBean.getCategorygroup());
	        pstmt.setString(2, cateBean.getCategoryname());
	        if(pstmt.executeUpdate() == 1)
	            flag = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        pool.freeConnection(con, pstmt);
	    }
	    return flag;
	}
}
