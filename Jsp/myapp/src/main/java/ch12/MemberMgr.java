package ch12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ch09.DBConnectionMgr;

public class MemberMgr {
    private DBConnectionMgr pool;

    public MemberMgr() {
        pool = DBConnectionMgr.getInstance();
    }

    // 로그인: 성공은 true 리턴
    public boolean loginChk(String id, String pwd) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        boolean flag = false;
        try {
            con = pool.getConnection();
            sql = "select count(id) from tblmember where id = ? and pwd = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) == 1)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                pool.freeConnection(con, pstmt, rs);
            }
        }
        return flag;
    }
}














