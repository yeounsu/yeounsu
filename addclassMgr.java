package onedaybaking;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedaybaking.CateBean;
import onedaybaking.ClassBean;

public class addclassMgr {
	private DBConnectionMgr pool;
	//업로드 파일 저장 위치
		public static final String SAVEFOLDER="C:/Jsp/myapp/src/main/webapp/onedaybaking/img/";
		//업로드 파일 인코딩
		public static final String ENCODING="UTF-8";
		public static final int MAXSIZE = 1024 * 1024 * 20; //20MB
	public addclassMgr() {
		pool = DBConnectionMgr.getInstance();
	}
//	public void insertClass(addclassBean classBean) {
//        Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;
//		try {
//			con = pool.getConnection();
//			 sql = "INSERT INTO classes (member_id, classname, classdate, classmin, classmax, classprice, classtime, addressdetail, categorykey, offercontent, classtatus, classteacherinfo, classteacherimg, classimg1, classimg2, classimg3, classimg4, classimg5, classcontent, roomimg1, roomimg2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	            pstmt = con.prepareStatement(sql);
//	            pstmt.setString(1, classBean.getMemberId());
//	            pstmt.setString(2, classBean.getClassname());
//	            pstmt.setString(3, classBean.getClassdate());
//	            pstmt.setInt(4, classBean.getClassmin());
//	            pstmt.setInt(5, classBean.getClassmax());
//	            pstmt.setInt(6, classBean.getClassprice());
//	            pstmt.setInt(7, classBean.getClasstime());
//	            pstmt.setString(8, classBean.getAddressdetail());
//	            pstmt.setInt(9, classBean.getCategorykey());
//	            pstmt.setString(10, classBean.getOffercontent());
//	            pstmt.setString(11, classBean.getClassstatus());
//	            pstmt.setString(12, classBean.getClassteacherinfo());
//	            pstmt.setString(13, classBean.getClassteacherimg());
//	            pstmt.setString(14, classBean.getClassimg1());
//	            pstmt.setString(15, classBean.getClassimg2());
//	            pstmt.setString(16, classBean.getClassimg3());
//	            pstmt.setString(17, classBean.getClassimg4());
//	            pstmt.setString(18, classBean.getClassimg5());
//	            pstmt.setString(19, classBean.getClasscontent());
//	            pstmt.setString(20, classBean.getRoomimg1());
//	            pstmt.setString(21, classBean.getRoomimg2());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				addclassBean bean = new addclassBean();
//				bean.setMemberId(rs.getString(1));
//				bean.setClassname(rs.getString(2));
//				bean.setClassdate(rs.getString(3));
//				bean.setClassmin(rs.getInt(4));
//				bean.setClassmax(rs.getInt(5));
//				bean.setClassprice(rs.getInt(6));
//				bean.setClasstime(rs.getInt(7));
//				bean.setAddressdetail(rs.getString(8));
//				bean.setCategorykey(rs.getInt(9));
//				bean.setOffercontent(rs.getString(10));
//				bean.setClassstatus(rs.getString(11));
//				bean.setClassteacherinfo(rs.getString(12));
//				bean.setClassteacherimg(rs.getString(13));
//				bean.setClassimg1(rs.getString(14));
//				bean.setClassimg2(rs.getString(15));
//				bean.setClassimg3(rs.getString(16));
//				bean.setClassimg4(rs.getString(17));
//				bean.setClassimg5(rs.getString(18));
//				bean.setClasscontent(rs.getString(19));
//				bean.setRoomimg1(rs.getString(20));
//				bean.setRoomimg2(rs.getString(21));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			pool.freeConnection(con, pstmt, rs);
//		}
// 
//}
	
	public boolean insertClass(HttpServletRequest req , String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			MultipartRequest multi = new MultipartRequest(req, SAVEFOLDER, MAXSIZE, ENCODING, new DefaultFileRenamePolicy());
			sql = "INSERT INTO class ( classname, classdate, classmin, classmax, classprice, classtime, address, addressdetail,offercontent, classstatus, classdelete, classteacherinfo, classteacherimg, classimg1, classimg2, classimg3, classimg4, classimg5, classcontent, roomimg1, roomimg2, memberid, categorykey, membername, classteachername) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
	
			int ckey = getCatekey();
			 pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, multi.getParameter("classname"));
	            pstmt.setString(2,multi.getParameter("classdate"));
	            pstmt.setInt(3,Integer.parseInt(multi.getParameter("classmin")));
	            pstmt.setInt(4,Integer.parseInt(multi.getParameter("classmax")));
	            pstmt.setInt(5, Integer.parseInt(multi.getParameter("classprice")));
	            pstmt.setInt(6, Integer.parseInt(multi.getParameter("classtime")));
	            pstmt.setString(7, multi.getParameter("address"));
	            pstmt.setString(8, multi.getParameter("addressdetail"));
	            pstmt.setString(9, multi.getParameter("offercontent"));
	            pstmt.setString(10, multi.getParameter("classstatus"));
	            
	            pstmt.setString(11, multi.getParameter("Offercontent"));
			
			///////////////////////////////////
			//{"인터넷", "여행", "영화"} 
	            String cstatus[] = multi.getParameterValues("Classstatus");
	            char hb[] = {'0','0','0','0','0','0','0','0','0','0','0','0'};
	            String lists[] = {"와이파이를 제공해요", "포토존이 있어요", "주차공간이 있어요", "반려동물 동반이 가능해요", "간단한 음료 및 다과를 제공해요","앞치마 및 장갑을 제공해요","포장 용기를 제공해요","손세정제가 비치 되어있어요","아이 동반은 추천하지 않아요","실내 소독을 해요","날카로운 도구들을 많이 사용해요","거리두기를 준수해요"}; 

	            if(cstatus!=null) { //
	            for (int i = 0; i < cstatus.length; i++) {
	                for (int j = 0; j < lists.length; j++) {
	                    if(cstatus[i].equals(lists[j])) {
	                        hb[j] = '1';
	                        break;
	                    }//---if
	                }//---for2
	            }//---for1
	            //new String(char value[])
	            }
	            pstmt.setString(12, new String(hb));
			///////////////////////////////////
	            pstmt.setString(13, "N");
			 pstmt.setString(14, multi.getParameter("Classteacherinfo"));
	            pstmt.setString(15, multi.getParameter("Classteacherimg"));
	            pstmt.setString(16, "");
	            pstmt.setString(17, "");
	            pstmt.setString(18, "");
	            pstmt.setString(19, "");
	            pstmt.setString(20, "");
	            pstmt.setString(21, "");
	            pstmt.setString(22, "");
	            pstmt.setString(23, "");
	            pstmt.setString(24, id);
	            pstmt.setInt(25, ckey);
	            pstmt.setString(26, multi.getParameter("membername"));
	            pstmt.setString(27, multi.getParameter("classteachername"));
	            
	            

			if(pstmt.executeUpdate()==1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	public int getCatekey() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int num = 0;
		try {
			con = pool.getConnection();
			sql = "select * from category order by categorykey desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) num = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return num;
	}
	
	public boolean insertCate(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag1 = false;
		try {
			con = pool.getConnection();
			MultipartRequest multi = new MultipartRequest(req, SAVEFOLDER, MAXSIZE, ENCODING, new DefaultFileRenamePolicy());
			sql = "insert into category (categorygroup, categoryname) values (?,?)";
			 pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, multi.getParameter("categorygroup"));
	            pstmt.setString(2, multi.getParameter("categoryname"));
	            
			if(pstmt.executeUpdate()==1)
				flag1 = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag1;
	}

		
	


	public boolean allInsertClass(HttpServletRequest req, String id) {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    String sql = null;
	    boolean flag = false;
	    try {
	        con = pool.getConnection();
	        MultipartRequest multi = new MultipartRequest(req, SAVEFOLDER, MAXSIZE, ENCODING, new DefaultFileRenamePolicy());
	        sql = "insert into category (categorygroup, categoryname) values (?,?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, multi.getParameter("categorygroup"));
	        pstmt.setString(2, multi.getParameter("categoryname"));

	        if (pstmt.executeUpdate() == 1) {
	            pool.freeConnection(con, pstmt);

	            int ckey = getCatekey();
	            con = pool.getConnection();
	            sql = "INSERT INTO class ( classname, classdate, classmin, classmax, classprice, classtime, address, addressdetail,offercontent, classstatus, classdelete, classteacherinfo, classteacherimg, classimg1, classimg2, classimg3, classimg4, classimg5, classcontent, roomimg1, roomimg2, memberid, categorykey, membername, classteachername) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, multi.getParameter("classname"));
	            pstmt.setString(2, multi.getParameter("classdate"));
	            String classmin = multi.getParameter("classmin");
	            if (!classmin.isEmpty()) {
	                pstmt.setInt(3, Integer.parseInt(classmin));
	            } else {
	                pstmt.setNull(3, java.sql.Types.INTEGER);
	            }
	            pstmt.setInt(4, Integer.parseInt(multi.getParameter("classmax")));
	            pstmt.setInt(5, Integer.parseInt(multi.getParameter("classprice")));
	            pstmt.setInt(6, Integer.parseInt(multi.getParameter("classtime")));
	            pstmt.setString(7, multi.getParameter("address"));
	            pstmt.setString(8, multi.getParameter("addressdetail"));

	            pstmt.setString(9, multi.getParameter("offercontent"));

	            // Classstatus 처리
	            String a = multi.getParameter("classstatus");
	            String cstatus[] = a.split(",");
	            char hb[] = new char[12]; // 고정된 크기로 배열 생성
	            Arrays.fill(hb, '0'); // 모든 요소를 '0'으로 초기화
	            String lists[] = {"와이파이를 제공해요", "포토존이 있어요", "주차공간이 있어요", "반려동물 동반이 가능해요", "간단한 음료 및 다과를 제공해요", "앞치마 및 장갑을 제공해요", "포장 용기를 제공해요", "손세정제가 비치 되어있어요", "아이 동반은 추천하지 않아요", "실내 소독을 해요", "날카로운 도구들을 많이 사용해요", "거리두기를 준수해요"};

	            if (cstatus != null) {
	                for (int i = 0; i < cstatus.length; i++) {
	                    for (int j = 0; j < lists.length; j++) {
	                        if (cstatus[i].equals(lists[j])) {
	                            hb[j] = '1';
	                            break;
	                        }
	                    }
	                }
	            }
	            pstmt.setString(10, new String(hb));

	            pstmt.setString(11, "N");
	            pstmt.setString(12, multi.getParameter("classteacherinfo"));
	            pstmt.setString(13, multi.getParameter("classteacherimg"));
	            for (int i = 14; i <= 21; i++) {
	                pstmt.setString(i, ""); // 빈 문자열 삽입
	            }
	            pstmt.setString(22, id);
	            pstmt.setInt(23, ckey);
	            pstmt.setString(24, multi.getParameter("membername"));
	            pstmt.setString(25, multi.getParameter("classteachername"));

	            if (pstmt.executeUpdate() == 1) {
	                flag = true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (con != null) {
	            pool.freeConnection(con);
	        }
	    }
	    return flag;
	}
}

    


