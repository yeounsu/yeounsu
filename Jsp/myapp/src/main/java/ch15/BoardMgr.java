																	package ch15;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ch15.UtilMgr;



public class BoardMgr {
	private DBConnectionMgr pool;
	public static final String SAVEFOLDER = "./img";
	public static final String ENCODING = "UTF-8";
	public static final int MAXSIZE = 1024*1024*20;

public BoardMgr() {
	pool = DBConnectionMgr.getInstance();
}
//Board Insert
public void insertBoard(HttpServletRequest req) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		File dir = new File(SAVEFOLDER);
		if(!dir.exists())//존재하지 않다면
			dir.mkdirs(); //상위 폴더가 없어도 생성 mkdir -> 상위 폴더가 없으면 생성이 불가능하다.
		MultipartRequest multi = new MultipartRequest(req, SAVEFOLDER, MAXSIZE, ENCODING, new DefaultFileRenamePolicy());
		String filename = null;
		int filesize = 0;
		if(multi.getFilesystemName("filename")!=null) {
			filename = multi.getFilesystemName("filename");
			filesize =(int)multi.getFile("filename").length();
		}
		String content = multi.getParameter("content");
		String contentType = multi.getParameter("contentType");
		if(contentType.equals("TEXT")) {
			//<-> &it;
			content = UtilMgr.replace(content,"<","&It;");
		}
		int ref = getMaxNum()+1; //답변을 위한 ref 설정
		con = pool.getConnection();
		sql = "insert tblBoard(name,content,subject,ref,pos,depth,";
		sql += "regdate,pass,count,ip,filename,filesize)";
		sql += "values(?, ?, ?, ?, 0, 0, now(), ?, 0, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, multi.getParameter("name"));
		pstmt.setString(2, content);
		pstmt.setString(3, multi.getParameter("subject"));
		pstmt.setInt(4,ref);
		pstmt.setString(5, multi.getParameter("pass"));
		pstmt.setString(6, multi.getParameter("ip"));
		pstmt.setString(7,filename);
		pstmt.setInt(8,filesize);
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	
}
//Board Max Num : num의 현재 최대값
public int getMaxNum() {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	int maxNum = 0;
	try {
		con = pool.getConnection();
		sql = "select max(num) from tblBoard";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) maxNum = rs.getInt(1);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);
	}
	return maxNum;
}
//Board Total Count : 총 게시물수 
public int getTotalCount(String keyField, String keyWord) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	int totalCount = 0;
	try {
		con = pool.getConnection();
		if(keyWord.trim().equals("")||keyWord==null) {
			//검색이 아닌경우
			sql = "select count(*) from tblBoard";
			pstmt = con.prepareStatement(sql);
		}else {
			//검색인 경우 
			sql = "select count(*) from tblBoard"
					+ "where" + keyField + "like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" +keyWord+ "%");
		}
		

		rs = pstmt.executeQuery();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);
	}
	return totalCount;
}
//Board List : 검색기능, 페이징 및 블럭
public Vector<BoardBean> getBoardList(String keyField, String keyWord,int start, int cnt){
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	Vector<BoardBean> vlist = new Vector<BoardBean>();
	try {
		con = pool.getConnection();
		if(keyWord.trim().equals("")||keyWord==null) {
			//검색이 아닌경우
			sql = "select * from tblBoard order by ref desc,pos limit ?,?";
			pstmt = con.prepareStatement(sql);
		}else {
			//검색인 경우 
			sql = "select count(*) from tblBoard"
					+ "where" + keyField + "like ?"
					+ " order by ref desc,pos limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" +keyWord+ "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, cnt);
		}
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
		    BoardBean bean = new BoardBean();
		    bean.setNum(rs.getInt("num"));
		    bean.setName(rs.getString("name"));
		    bean.setSubject(rs.getString("subject"));
		    bean.setPos(rs.getInt("pos"));
		    bean.setRef(rs.getInt("ref"));
		    bean.setRef(rs.getInt("depth"));
		    bean.setRegdate(rs.getString("regdate"));
		    bean.setCount(rs.getInt("count"));
		    bean.setFilename(rs.getString("filename"));
		    vlist.addElement(bean);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);
}
	return vlist;
}
	//Board Read : 13개 컬럼 모두 리턴 
	public BoardBean getBoard(int num) {
		    Connection con = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    BoardBean board = null;

		    try {
		        con = pool.getConnection(); 
		        
		        String sql = "SELECT * FROM tblboard WHERE num = ?";

		        pstmt = con.prepareStatement(sql);
		        pstmt.setInt(1, num);

		        rs = pstmt.executeQuery();

		        if (rs.next()) {
		            // 게시물의 모든 컬럼 값을 BoardBean 객체에 설정
		            board = new BoardBean();
		            board.setNum(rs.getInt("num"));
		            board.setName(rs.getString("name"));
		            board.setSubject(rs.getString("subject"));
		            board.setContent(rs.getString("content"));
		            // 나머지 컬럼들도 이와 같은 방식으로 설정
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        // 자원 해제
		        if (rs != null) {
		            try {
		                rs.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		        if (pstmt != null) {
		            try {
		                pstmt.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		        if (con != null) {
		            try {
		                con.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    return board;
		

	}
//Count Up : 조회수 증가
public void upCount(int num) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "updqte set count=count+1 where num=?";
		pstmt.setInt(1,num);
		pstmt = con.prepareStatement(sql);
	
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	return;
}
//Board Delete : 첨부된 파일 삭제 
public void deleteBoard(int num) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		BoardBean bean = getBoard(num);
		String filename = bean.getFilename();
		if(filename!=null&&!filename.equals("")) {
			File f = new File(SAVEFOLDER+filename);
			if(f.exists()) {
				UtilMgr.delete(SAVEFOLDER+filename);
			}
		}
		
		con = pool.getConnection();
		sql = "delete from tblBoard where num =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	
}
//Board Update : 파일 업로드 수정
public void updateBoard(MultipartRequest multi) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		int num = Integer.parseInt(multi.getParameter("num"));
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("filename");
		if(filename!=null&&!filename.equals("")) {
			//파일 업로드도 수정 : 기존에 파일 삭제 
			BoardBean bean = getBoard(num);
			String tempfile = bean.getFilename();
			if(tempfile!=null&&!tempfile.equals("")) {
				File f = new File(SAVEFOLDER+tempfile);
				if(f.exists()) {
					UtilMgr.delete(SAVEFOLDER+tempfile);
				}
			}
			int filesize = (int)multi.getFile("filename").length();
			sql = "update tblBoard set name=?, subject=?, content=?,"
					+ "filename=?, filesize=? where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			pstmt.setString(4, filename);
			pstmt.setInt(5, filesize);
			pstmt.setInt(6, num);
			
		}else {
			sql = "update tblBoard set name=?, subject=?, content=? "
					+ "where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			pstmt.setInt(4, num);
		}
		
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	
}
//Board Reply : 답변글 저장
public void replyBoard(BoardBean bean) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "insert tblBoard(name,content,subject,ref,pos,depth,regdate,"
				+ "pass,count,ip)values(?, ?, ?, ?, ?, ?, now(), ?, 0, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getContent());
		pstmt.setString(3, bean.getSubject());
		///////////////////
		pstmt.setInt(4, bean.getRef());//원글과 동일한 ref (그룹)
		pstmt.setInt(5, bean.getPos()+1);//원글 pos+1(정렬)
		pstmt.setInt(6, bean.getDepth()); //원글 depth +1
		/////////////////////////
		pstmt.setString(7, bean.getPass());
		pstmt.setString(8, bean.getIp());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	
}
//Board Reply Up : 답변글 위치값 수정
public void replyUpBoard(int ref, int pos) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "update tblBoard set pos=pos+1 where ref=? and pos>?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ref);
		pstmt.setInt(2, pos);
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
	
}
//게시물을 100입력
public void post1000(){
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	try {
		con = pool.getConnection();
		sql = "insert tblBoard(name,content,subject,ref,pos,depth,regdate,pass,count,ip,filename,filesize)";
		sql+="values('aaa', 'bbb', 'ccc', 0, 0, 0, now(), '1234',0, '127.0.0.1', null, 0);";
		pstmt = con.prepareStatement(sql);
		for (int i = 0; i < 1000; i++) {
			pstmt.executeUpdate();
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt);
	}
}
public static void main(String[] arhs) {
	BoardMgr mgr = new BoardMgr();
	mgr.post1000();
	System.out.println("입력성공");
}
}
