package ch14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ch09.DBConnectionMgr;

public class MemberMgr {
    private DBConnectionMgr pool;

    public MemberMgr() {
        pool = DBConnectionMgr.getInstance();
    }
    
    

    // 로그인
    public boolean loginMember(String id, String pwd) {
      Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	boolean flag = false;
	try {
		con = pool.getConnection();
		sql = "select id from tblMember where id =? and pwd=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);

		rs = pstmt.executeQuery();
		if(rs.next()) flag = true;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);
	}
return flag;
    }

  //id 중복체크
    public boolean checkId(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;
        String sql = null;

        try {
            con = pool.getConnection();
            sql = "SELECT COUNT(*) AS count FROM tblmember WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next())  flag = true; // 아이디가 이미 존재함
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return flag;
    }

    //우편번호 검색
    //select * from tblZipcod where area3 like '%강남대로%'
    public Vector<ZipcodeBean> searchZipcode(String area3) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        Vector<ZipcodeBean> vlist = new Vector<>();

        try {
            con = pool.getConnection();
            sql = "SELECT * FROM tblZipcode WHERE area3 LIKE ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + area3 + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vlist.addElement(new ZipcodeBean(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return vlist;
    }
    //회원가입
    public boolean insertMember(MemberBean bean) {
Connection con = null;
PreparedStatement pstmt = null;
String sql = null;
boolean flag = false;
try {
	con = pool.getConnection();
	sql = "update tblMember set pwd=?,name=?,gender=?,"
			+ "birthday=?,email=?,zipcode=?,address=?,hobby=?"
			+ ",job=? where id=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, bean.getPwd());
	pstmt.setString(2, bean.getName());
	pstmt.setString(3, bean.getGender());
	pstmt.setString(4, bean.getBirthday());
	pstmt.setString(5, bean.getEmail());
	pstmt.setString(6, bean.getZipcode());
	pstmt.setString(7, bean.getAddress());
	String lists[] = { "인터넷", "여행", "게임", "영화", "운동" };
	String hobby[] = bean.getHobby(); //{"인터넷","운동"}
	char hb[] = {'0','0','0','0','0'};
	for (int i = 0; i < hobby.length; i++) {
		for (int j = 0; j < lists.length; j++) {
			if(hobby[i].equals(lists[j])) {
				hb[j] = '1';
				break;
			}
		}
	}
	//{'1','0','0','0','1'};
	pstmt.setString(8,new String(hb));//"10001" 로 출력
	pstmt.setString(9, bean.getJob());
	pstmt.setString(10, bean.getId());
	if(pstmt.executeUpdate()==1)flag = true;
	pstmt.executeUpdate();
} catch (Exception e) {
	e.printStackTrace();
} finally {
	pool.freeConnection(con, pstmt);
}
return flag;
    }
    //회원정보 가져오기
	public MemberBean getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select*from tblMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setGender(rs.getString("gender"));
				bean.setBirthday(rs.getString("birthday"));
				bean.setEmail(rs.getString("email"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				String hobby = rs.getString("hobby"); //10001
				String hb[] = new String[hobby.length()];
				for (int i = 0; i < hb.length; i++) {
					hb[i] = hobby.substring(i,i+1);
				} //{"1","0","0","0","1"}
				bean.setHobby(hb);
				bean.setJob(rs.getString("job"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}return bean;
	} 
    //회원정보 수정
	//회원정보 수정
		public boolean updateMember(MemberBean bean) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update tblMember set pwd=?,name=?,gender=?,"
						+ "birthday=?,email=?,zipcode=?,address=?,hobby=?"
						+ ",job=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getPwd());
				pstmt.setString(2, bean.getName());
				pstmt.setString(3, bean.getGender());
				pstmt.setString(4, bean.getBirthday());
				pstmt.setString(5, bean.getEmail());
				pstmt.setString(6, bean.getZipcode());
				pstmt.setString(7, bean.getAddress());
				////////////////////////////////////
				String lists[] = { "인터넷", "여행", "게임", "영화", "운동" };
				String hobby[] = bean.getHobby();    //{"인터넷", "운동"}
				char hb[]  = {'0','0','0','0','0'};
				for(int i=0; i<hobby.length; i++) {
					for(int j =0; j<lists.length; j++) {
						if(hobby[i].equals(lists[j])) {
							hb[j] ='1';
							break;
						}
					}
				}
				//{'1','0','0','0','1'};
				pstmt.setString(8, new String(hb));  //문자열("10001")로 저장
				//////////////////////////////////////////
				pstmt.setString(9, bean.getJob());
				pstmt.setString(10, bean.getId());
				if(pstmt.executeUpdate()==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
			
		}
}












